package com.netcracker;

import javax.servlet.http.*;
import javax.servlet.ServletException;
import java.io.*;


public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        String login = (String)req.getParameter("login");
        String password = (String)req.getParameter("password");
        pw.print("<!DOCTYPE html>\n" +
                "<html>\n" +
                "\t<head>\n" +
                "\t\t<meta charset=\"utf-8\">\n" +
                "\t\t<title>My first Servlet</title>\n" +
                "\t</head>" +
                "<body>\n" +
                "<h1> Hello " + login + "</h1>" +
                "\t</body>\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
