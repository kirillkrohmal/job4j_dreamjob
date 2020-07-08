package ru.job4j;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.mockito.UserServlet;
import ru.job4j.mockito.Validate;
import ru.job4j.mockito.ValidateService;
import ru.job4j.mockito.ValidateStub;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ru.job4j.fileservlet.model.User;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class MockitoTest {

    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
    }


    @Test
    public void whenAddUserThenStoreIt2() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
        assertThat(validate.getAll().iterator().next().getName(), is("Petr Arsentev"));
    }

    @Test
    public void whenAddUserThenStoreIt3() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
        User user = new User(1, "Ivan");
        validate.add(user);
        assertThat(validate.getAll().iterator().next().getName(), is("Ivan"));
    }

    @Test
    public void whenAddUserThenStoreIt4() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
        User user = new User(1, "Ivan");
        validate.delete(user);
        assertThat(validate.getAll().iterator().next().getName(), is("Petr Arsentev"));
    }

    @Test
    public void whenAddUserThenStoreIt5() throws ServletException, IOException {
        Validate validate = new ValidateStub();
        PowerMockito.mockStatic(ValidateService.class);
        Mockito.when(ValidateService.getInstance()).thenReturn(validate);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        when(req.getParameter("name")).thenReturn("Petr Arsentev");
        new UserServlet().doPost(req, resp);
        User user = new User(1, "Ivan");
        validate.add(user);
        User user2 = new User(1, "Ivan2");
        validate.edit(user2);
        assertThat(validate.getAll().iterator().next().getName(), is("Ivan2"));
    }
}
