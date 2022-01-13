import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie [] cookies = request.getCookies();
        Cookie currentUserCookie = null;
        if(cookies!=null)
        {
            for(Cookie cookie:cookies)
            {
                if (cookie.getName().equals("currentUser"))
                {
                    currentUserCookie = cookie;
                }
            }
        }

        if (currentUserCookie!=null)
        {
            currentUserCookie.setMaxAge(0);
            response.addCookie(currentUserCookie);
        }
        response.sendRedirect("login.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
