import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Home on 6/08/2015.
 */
public class GreetingServlet  extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = (String)req.getParameter("username");
        resp.getWriter().write( "Hello " + username + ", welcome to my world!");
        resp.getWriter().flush();
        resp.getWriter().close();
    }

}
