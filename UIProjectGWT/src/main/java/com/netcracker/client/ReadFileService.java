package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.shared.Book;

import java.util.ArrayList;

@RemoteServiceRelativePath("readFile")
public interface ReadFileService extends RemoteService {
    ArrayList<Book> readFile();
}
