package com.netcracker.servlets;

import com.netcracker.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class ServletChangePassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String password = req.getParameter("password");
        String path = getServletContext().getRealPath("users.txt");
        String login = Users.loginWithWrongPassword;

        changePassword(login, password, path);

        PrintWriter pw = resp.getWriter();
        if(password != null) {
            pw.print("Your password was changed");
            pw.close();
        }
        else{
            pw.print("Please, enter not empty password");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    public void changePassword(String login, String password, String path) {
        try{
            FileReader fr = new FileReader(path);
            ArrayList<String> temp = new ArrayList<>();
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line != null) {
                if(line.equals(login)){
                    line = reader.readLine();   //write in temporary arraylist all lines except two of deleted login and password
                    line = reader.readLine();
                }
                else{
                    temp.add(line);
                    line = reader.readLine();
                }
            }
            fr.close();
            reader.close();

            FileWriter fw = new FileWriter(path); //writing empty string in file to delete everything from it
            fw.write("");
            fw.close();

            FileWriter writer = new FileWriter(path, true);  //write all items from temporary arraylist
            for(String t : temp) {
                writer.write(t + "\n");
            }
            writer.write(login + "\n");   //add login and new password
            writer.write(password + "\n");
            writer.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
