import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "TranslateServlet", urlPatterns = "/translate")
public class TranslateServlet  extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("book", "sách");
        dictionary.put("pen", "vở");
        dictionary.put("laptop", "máy tính sách tay");
        dictionary.put("watch", "đồng hồ");
        String search = req.getParameter("txtSearch");

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        String result = dictionary.get(search);
        if (result!= null){
            writer.println("<h1> word: "+search+"<br>");
            writer.println(" result: "+result+"<br></h1>");
        }else writer.println("word not found");
        writer.println("</html>");
    }
}
