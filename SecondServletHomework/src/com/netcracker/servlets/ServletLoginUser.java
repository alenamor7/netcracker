package com.netcracker.servlets;

import com.netcracker.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;


public class ServletLoginUser extends HttpServlet {

    int n = 0;
    String printedString = "";   //string which will be printed as the result of program
    Cookie cookie;
    ArrayList<String> loginUsers = new ArrayList<>(); //list of all logged users

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String path = getServletContext().getRealPath("users.txt");  //is placed in out/artefacts
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String remember = req.getParameter("checkbox");

        HttpSession session = req.getSession(true);
        PrintWriter pw = resp.getWriter();

        Users users = new Users(login, password, path);

        if(!session.isNew() && !users.validation() && cookie.getValue() != null && session.getAttribute("login") != null){
            printedString = "Welcome, " + cookie.getValue();
            //printedString = "Welcome, " + session.getAttrubute("login");
            printedString += "\n(value of session's atribute: " + session.getAttribute("login") +
                    "; value of cookie: " + cookie.getValue() + ")";  //for visualisation of result
        }
        else{
            if(users.validation()) {   //check if fileds are filled with nin-null Strings
                if (users.islogged()) {  //check if user if logged
                    if ("on".equals(remember)) {
                        session.setAttribute("login", login);
                        session.setAttribute("password", password);
                        cookie = new Cookie("login", login);
                        resp.addCookie(cookie);
                        loginUsers.add(cookie.getValue());
                    }
                }
                else if(users.wrongPassword()){
                    n++;
                    if(n > 3) {
                        redirect(req, resp, "change_password.html");
                    }
                }
                else{
                    redirect(req, resp, "create.html");
                }
            }
            printedString = users.getPrintedString();
        }
        pw.println(printedString);
        pw.close();
    }


    protected void redirect(HttpServletRequest req, HttpServletResponse resp, String path) {

        try {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
            requestDispatcher.forward(req, resp);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
