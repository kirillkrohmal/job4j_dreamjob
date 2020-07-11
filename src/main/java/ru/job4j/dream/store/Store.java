package ru.job4j.dream.store;

import org.apache.taglibs.standard.lang.jstl.Literal;
import ru.job4j.auth.model.User;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {
    private static final Store INST = new Store();
    private static final AtomicInteger POST_ID = new AtomicInteger();

    private Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private List<User> vacancy = new ArrayList<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job"));
        posts.put(2, new Post(2, "Middle Java Job"));
        posts.put(3, new Post(3, "Senior Java Job"));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
    }

    public static Store instOf() {
        return INST;
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void add(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void get(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }

        posts.get(post.getId());
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Candidate findById2(int id) {
        return candidates.get(id);
    }


    public void save2(Candidate candidate) {
        candidate.setId(POST_ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }


    public void add2(Candidate candidate) {
        candidate.setId(POST_ID.incrementAndGet());
        candidates.put(candidate.getId(), candidate);
    }

    public void get2(Candidate candidate) {
        candidate.setId(POST_ID.incrementAndGet());
        candidates.get(candidate.getId());
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public void findByEmail(User users) {
        for (User user : vacancy) {
            user.getEmail();
        }


    }
}
