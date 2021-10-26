
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class InfoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        String browser = req.getHeader("user-agent");
        Date date = new Date();

        pw.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>Servlet with info about date and browser</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                "\t\t<h2> Hello</h2>\n" +
                "\t\t<p> Current date and time are " + date.toString()+ "</p>\n"+
                "\t\t<p> Your browser is " + browser + "</p>\n" +
                "\t</body>\n" +
                "</html>"
        );

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
