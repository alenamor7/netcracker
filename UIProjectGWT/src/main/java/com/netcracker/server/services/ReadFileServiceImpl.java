package com.netcracker.server.services;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.netcracker.client.ReadFileService;
import com.netcracker.server.ReadFileFromJson;
import com.netcracker.shared.Book;

import java.io.File;
import java.util.ArrayList;

public class ReadFileServiceImpl extends RemoteServiceServlet implements ReadFileService {
    @Override
    public ArrayList<Book> readFile() {
        String path = getServletContext().getRealPath("/") + "library.json";
        return new ReadFileFromJson().read(path);
    }
}
