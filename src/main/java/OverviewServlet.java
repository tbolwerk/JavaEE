import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
@Named
@WebServlet
public class OverviewServlet extends HttpServlet {
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Controller.checkLoggedIn(session,resp);

        session.setAttribute("current","overview");
        Controller controller = new Controller();
        try {
            movies = controller.getMovies();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        req.getRequestDispatcher("header.jsp").include(req, resp);


        String contentStart = "<div class=\"content\">";
        String contentEnd = "</div>";
        writer.println(contentStart);
        for (Movie movie: movies) {
            int movie_id = movie.getMovie_id();
            String poster = "\"img/posters/"+movie.getCover_image()+"\"";
            String title = movie.getTitle();
            String description = movie.getDescription();

        writer.println( "            <div class=\"info-box\" onclick=\"window.location='movieservlet?movie_id="+movie_id+"'\">\n" +
                "                <img src="+poster+"/>\n" +
                "                <div class=\"hidden-info-box\">\n" +
                "                    <h1>"+title+"</h1>\n" +
                "                    <p>"+description+"</p>\n" +
                "                </div>\n" +
                "            </div>");
        }





        writer.println(contentEnd);
        req.getRequestDispatcher("footer.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getAttribute("user") == null){
            PrintWriter writer = resp.getWriter();
            writer.println("error overview");
            return;
        }
        doGet(req,resp);
    }
}
