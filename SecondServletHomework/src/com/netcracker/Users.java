package com.netcracker;

import java.io.*;


public class Users {
    public static String loginWithWrongPassword = "";
    String login;
    String password;
    String path;
    String printedString = "";


    public Users(String login, String password, String path) {
        this.login = login;
        this.password = password;
        this.path = path;
    }

    public String getPrintedString() {
        return printedString;
    }

    public boolean islogged(){  //method used inServletLoginUser
        boolean log = false;
        this.getClass().getResourceAsStream("users.txt");
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.equals(login)) {
                    line = bufferedReader.readLine();
                    if (line.equals(password)) {
                        printedString = "Welcome, " + login;
                        log = true;
                    }
                }
                else{
                    line = bufferedReader.readLine(); //to avoid comparison with password if login is not equals
                }
                line = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return log;
    }

    public boolean wrongPassword(){  //method used inServletLoginUser
        boolean wrong = false;
        this.getClass().getResourceAsStream("users.txt");
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.equals(login)) {
                    loginWithWrongPassword = line.toString();
                    line = bufferedReader.readLine();
                    if (!line.equals(password)) {
                        printedString = "Please, enter correct password";
                        wrong = true;
                    }
                } else {
                    line = bufferedReader.readLine(); //to avoid comparison with password if login is not equals
                }
                line = bufferedReader.readLine();
            }
            fileReader.close();
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return wrong;
    }

    public boolean validation(){   //method used in ServletLoginUser and ServletCreateUser
        if("".equals(login)){
            printedString = "Please, enter not empty login";
            return false;
        }
        if("".equals(password)){
            printedString = "Please, enter not empty password";
            return false;
        }
        return true;
    }


    public boolean notReservedLogin() {   //used in ServletCreateUser to avoid creating accounts with equal logins
        boolean notReserved = true;
        try{
            FileReader fr = new FileReader(path);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while(line != null) {
                if(line.equals(login)){
                    printedString = "Sorry, this login is already reserved";
                    notReserved = false;
                }
                line = reader.readLine();
                line = reader.readLine();
            }
            fr.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        return notReserved;
    }

    public void writeUser(){   //used in ServletCreateUser
        try{
            FileWriter writer = new FileWriter(path, true);
            if(notReservedLogin()) {
                writer.write(login +"\n");
                writer.write(password + "\n");
                printedString = "Your account has been created. Thank you!";
            }
            writer.close();
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
