package com.netcracker;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;

public class MyModifiedServlet extends HttpServlet {

    private String pass = "password123";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String login = (String)req.getParameter("login");
        String password = (String)req.getParameter("password");
        String resultString = getResult(login, password);
        pw.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>My modified servlet</title>\n" +
                "\t</head>\n" +
                "\t<body>\n" +
                resultString +
                "\t</body>\n" +
                "</html>"
        );
    }

    public String getResult(String login, String password) {
        String resultString = "";
        if(login.length() == 0) {
            resultString += "\t\t<h2>The field \"Login\" has to be non-empty</h2>\n";
        }
        else if(login.length() >= 30) {
            resultString += "\t\t<h2>Login should have less then 30 characters</h2>\n";
        }
        if(password.length() == 0) {
            resultString += "\t\t<h2>The field \"Password\" has to be non-empty</h2>\n";
        }
        else if(password.length() >= 20) {
            resultString += "\t\t<h2>Password should have less then 20 characters</h2>\n";
        }
        else {
            if(pass.equals(password)) {
                resultString += "\t\t<h2>You entered a correct password </h2>\n";
            }
            else{
                resultString += "\t\t<h2>You entered incorrect password </h2>\n";
            }
        }
        return resultString;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
