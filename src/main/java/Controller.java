import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Named
@RequestScoped
public class Controller {
    private static ArrayList<Movie> movies = new ArrayList<Movie>();

    public ArrayList<Movie> getMovies() throws SQLException {
        movies.clear();
        ConnectDB connectDB = new ConnectDB();
        Statement statement = connectDB.getConnection().createStatement();
        String query = "SELECT * FROM MOVIE";
        ResultSet resultSet = statement.executeQuery(query);
        return Movies(resultSet,movies);

    }

    public static ArrayList<Movie> Movies(ResultSet resultSet, ArrayList<Movie> movies) throws SQLException {
        while (resultSet.next()) {
            int movie_id = resultSet.getInt("movie_id");
            String title = resultSet.getString("title");
            String description = resultSet.getString("description");
            String cover_image = resultSet.getString("cover_image");
            movies.add(new Movie(movie_id, title, description, cover_image));
        }
        return movies;
    }

    public static void checkLoggedIn(HttpSession session, HttpServletResponse resp){
        if(session.getAttribute("user") == null){
            try {
                resp.sendRedirect("index.html");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
