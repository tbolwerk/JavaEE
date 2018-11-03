import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;


@Named
@WebServlet
public class MovieServlet extends HttpServlet {
    private Movie movie;
    private ArrayList<Genre> movie_genre = new ArrayList<Genre>();
    private ArrayList<Person> movie_directors = new ArrayList<Person>();
    private ArrayList<Person> movie_cast = new ArrayList<Person>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int request_movie_id = 0;
        ConnectDB connectDB = new ConnectDB();
        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();

        Controller.checkLoggedIn(session,resp);

        if(req.getParameter("movie_id") != null) {
            request_movie_id = Integer.parseInt(req.getParameter("movie_id"));


        }
        try {
            if(connectDB.getConnection() != null){

                String query = "SELECT \n" +
                        "   m.*\n" +
                        "   , \n" +
                        "   STUFF((SELECT ', ' + mg.genre_name \n" +
                        "    FROM Movie_Genre mg\n" +
                        "    WHERE m.movie_id = mg.movie_id\n" +
                        "    FOR XML PATH('')),1,1,'') [genre_name]\n" +
                        "   , \n" +
                        "   (SELECT ', ' + p.firstname,' ',p.lastname\n" +
                        "    FROM Movie_Director md INNER JOIN Person p ON md.person_id=p.person_id\n" +
                        "    WHERE m.movie_id = md.movie_id\n" +
                        "    FOR XML PATH('')) [movie_directors]\n" +
                        "   , \n" +
                        "   (SELECT ', ' + p.firstname,' ',p.lastname\n" +
                        "    FROM Movie_Cast mc INNER JOIN Person p ON mc.person_id=p.person_id\n" +
                        "    WHERE m.movie_id = mc.movie_id\n" +
                        "    FOR XML PATH('')) [movie_cast]\n" +
                        "FROM Movie m\n" +
                        "WHERE movie_id="+request_movie_id+"\n" +
                        "GROUP BY m.movie_id,m.title,m.duration,m.description,m.cover_image,m.previous_part,m.publication_year,m.URL,m.price\n" +
                        "ORDER BY 1";
                Statement statement = connectDB.getConnection().createStatement();


                ResultSet resultSet = statement.executeQuery(query);



                while (resultSet.next()){

                    int movie_id = resultSet.getInt("movie_id");
                    String title = resultSet.getString("title");
                    String description = resultSet.getString("description");
                    String cover_image = resultSet.getString("cover_image");
                    int publication_year = resultSet.getInt("publication_year");
                    int duration = resultSet.getInt("duration");
                    String URL = resultSet.getString("URL");
                    String movie_genre = resultSet.getString("genre_name");
                    String movie_cast = resultSet.getString("movie_cast");
                    String movie_directors= resultSet.getString("movie_directors");
                    movie = new Movie(movie_id,title,description,cover_image,publication_year,duration,URL,movie_genre,movie_directors,movie_cast);

                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        session.setAttribute("movie",movie);


        session.setAttribute("movie_cast",movie.getMovie_cast());
        session.setAttribute("movie_directors",movie.getMovie_directors());
        session.setAttribute("movie_genre",movie.getMovie_genre());


        session.setAttribute("movie_id",movie.getMovie_id());
        session.setAttribute("title",movie.getTitle());
        session.setAttribute("description",movie.getDescription());
        session.setAttribute("cover_image",movie.getCover_image());
        session.setAttribute("publication_year",movie.getPublication_year());
        session.setAttribute("duration",movie.getDurationTime());
        session.setAttribute("URL",movie.getURL());


        req.getRequestDispatcher("header.jsp").include(req, resp);
        req.getRequestDispatcher("movie.jsp").include(req, resp);
        req.getRequestDispatcher("footer.jsp").include(req, resp);

//TODO add functionality to adding movies to the favorite list
        if(req.getParameter("favorite") != null) {
            out.println("<script type=\"text/javascript\">");
            out.println("toastr.success(\"Successfully added "+getMovie().getTitle()+" to your favorite list.\")");
            out.println("</script>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);


    }

    public Movie getMovie() {
        return movie;
    }
}
