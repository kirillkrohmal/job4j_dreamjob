package ru.job4j.fileservlet.model;

public class User {
    private int id;
    private String name;
    private String email;
    private String photoId;

    public User(int id, String name, String email, String photoId) {
        this.id = id;
        this.name  = name ;
        this.email = email;
        this.photoId = photoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }
}
