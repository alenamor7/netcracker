package com.netcracker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();

        double a = Double.parseDouble(req.getParameter("coeffA"));
        double b = Double.parseDouble(req.getParameter("coeffB"));
        double c = Double.parseDouble(req.getParameter("coeffC"));

        EquatationModel model = new EquatationModel(a, b, c);

        pw.print(model.getResult());
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
