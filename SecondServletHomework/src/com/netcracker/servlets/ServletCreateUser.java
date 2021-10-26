package com.netcracker.servlets;

import com.netcracker.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class ServletCreateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String path = getServletContext().getRealPath("users.txt");
        Users user = new Users(login, password, path);

        if(user.validation()) {
            user.writeUser();
        }
        PrintWriter pw = resp.getWriter();
        pw.print(user.getPrintedString());
        pw.close();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
