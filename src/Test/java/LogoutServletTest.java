import com.javarush.bulimova.controller.LogoutServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class LogoutServletTest {

    @Test
    void testLogout() throws Exception {
        LogoutServlet servlet = new LogoutServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        HttpSession session = mock(HttpSession.class);

        when(req.getMethod()).thenReturn("GET");
        when(req.getSession(false)).thenReturn(session);

        servlet.service(req, resp);

        verify(session).invalidate();
        verify(resp).sendRedirect("login.jsp");
    }

    @Test
    void testLogoutNoSession() throws Exception {
        LogoutServlet servlet = new LogoutServlet();

        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);

        when(req.getMethod()).thenReturn("GET");
        when(req.getSession(false)).thenReturn(null);

        servlet.service(req, resp);

        verify(resp).sendRedirect("login.jsp");
    }
}
