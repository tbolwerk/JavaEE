import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

public class NewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        HttpSession session = req.getSession();
        Controller.checkLoggedIn(session,resp);

        session.setAttribute("current","new");
        req.getRequestDispatcher("header.jsp").include(req, resp);
        req.getRequestDispatcher("new.jsp").include(req, resp);
        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }

}
