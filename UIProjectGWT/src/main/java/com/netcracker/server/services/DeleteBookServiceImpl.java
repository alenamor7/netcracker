package com.netcracker.server.services;

import com.google.gson.Gson;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.DeleteBookService;
import com.netcracker.server.ReadFileFromJson;
import com.netcracker.shared.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DeleteBookServiceImpl extends RemoteServiceServlet implements DeleteBookService {
    @Override
    public void deleteBook(Book book) {
        String path = getServletContext().getRealPath("/") + "library.json";
        ArrayList<Book> library = new ReadFileFromJson().read(path);
        library.remove(book);
        try{
            FileWriter fw = new FileWriter(path);
            fw.write("");
            fw.close();
            FileWriter writer = new FileWriter(path, true);
            Gson gson = new Gson();
            for(Book b : library) {
                writer.write(gson.toJson(b) + "\n");
            }
            writer.close();

        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
