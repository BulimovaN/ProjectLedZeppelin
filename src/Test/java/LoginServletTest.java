import com.javarush.bulimova.controller.LoginServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class LoginServletTest {

    @Test
    void testLoginSuccess() throws Exception {
        LoginServlet servlet = new LoginServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getMethod()).thenReturn("POST");
        when(req.getParameter("username")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("12345");
        when(req.getSession()).thenReturn(session);

        servlet.service(req, resp);

        verify(session).setAttribute("user", "admin");
        verify(resp).sendRedirect("/");
    }

    @Test
    void testLoginFailure() throws Exception {
        LoginServlet servlet = new LoginServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getMethod()).thenReturn("POST");
        when(req.getParameter("username")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("wrong");
        when(req.getRequestDispatcher("/login.jsp")).thenReturn(dispatcher);

        servlet.service(req, resp);


        verify(req).setAttribute(eq("error"), eq("Неверный логин или пароль"));
        verify(dispatcher).forward(req, resp);
    }
}
