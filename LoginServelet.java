import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if ("root".equals(username) && "toor".equals(password)) {
            out.println("<html><body style='background:black;color:#00ff00;font-family:Courier;text-align:center;'>");
            out.println("<h2>✅ ACCESS GRANTED</h2>");
            out.println("<p>Welcome, " + username + ". SYSTEM OVERRIDE INITIATED...</p>");
            out.println("<script>setTimeout(() => { window.location.href = 'dashboard.html'; }, 2000);</script>");
            out.println("</body></html>");
        } else {
            response.sendRedirect("index.html?error=1");
        }
    }
}
