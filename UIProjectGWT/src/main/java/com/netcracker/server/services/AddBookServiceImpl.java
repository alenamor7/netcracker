package com.netcracker.server.services;

import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.AddBookService;
import com.netcracker.shared.Book;

import java.io.FileWriter;
import java.io.IOException;

public class AddBookServiceImpl extends RemoteServiceServlet implements AddBookService {
    @Override
    public void addBook(Book book) {
        String path = getServletContext().getRealPath("/") + "library.json";
        try{
            FileWriter writer = new FileWriter(path, true);
            Gson gson = new Gson();
            writer.write(gson.toJson(book) + "\n");
            writer.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
