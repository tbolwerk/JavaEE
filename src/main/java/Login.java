import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@Named
@WebServlet
public class Login extends HttpServlet {
    private User user = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("index.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("uname");
       String password =  req.getParameter("psw");
       PrintWriter out = resp.getWriter();

        try {
             user = new User(username,password);
         if(user.getUser_name() == null){
             req.getRequestDispatcher("header-index.jsp").include(req, resp);
             req.getRequestDispatcher("index.jsp").include(req, resp);
             req.getRequestDispatcher("footer.jsp").include(req, resp);
             out.println("<script type=\"text/javascript\">");
             out.println("toastr.error(\"Username or password incorrect try again!\")");
             out.println("</script>");
//             resp.sendRedirect("index.html");

             return;
         }
            HttpSession session = req.getSession();
            session.setAttribute("user",user.getUser_name());
            Cookie userName = new Cookie("userName",user.getUser_name());
            resp.addCookie(userName);
            resp.sendRedirect("overviewservlet");





//            String nextJSP = "/overviewservlet";
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
//            dispatcher.forward(req,resp);

            out.println("Welcome "+ user.getFirst_name() + " " + user.getLast_name()+"!");
            out.println(user.getBirth_date()+" "+user.getContract_type()+ " "+ user.getPayment_card_number() + " "+ user.getSubscription_start());


        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Failed");
            out.println(e);
        }
    }
}
