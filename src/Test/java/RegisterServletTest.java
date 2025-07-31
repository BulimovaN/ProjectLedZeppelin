import com.javarush.bulimova.controller.RegisterServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class RegisterServletTest {

    private RegisterServlet servlet;

    @BeforeEach
    void setUp() {
        servlet = new RegisterServlet();
    }

    @Test
    void testRegisterSuccess() throws Exception {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getMethod()).thenReturn("POST");
        when(req.getParameter("username")).thenReturn("newuser");
        when(req.getParameter("password")).thenReturn("newpass");
        when(req.getSession()).thenReturn(session);


        servlet.service(req, resp);

        verify(session).setAttribute("user", "newuser");
        verify(resp).sendRedirect("/");
    }

    @Test
    void testRegisterFailure() throws Exception {
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);

        when(req.getMethod()).thenReturn("POST");
        when(req.getParameter("username")).thenReturn("admin");
        when(req.getParameter("password")).thenReturn("any");
        when(req.getRequestDispatcher("/register.jsp")).thenReturn(dispatcher);

        servlet.service(req, resp);

        verify(req).setAttribute(eq("error"), eq("Пользователь уже существует"));
        verify(dispatcher).forward(req, resp);
    }
}
