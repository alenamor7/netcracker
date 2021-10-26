package com.netcracker.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.netcracker.shared.Book;

import java.util.ArrayList;

@RemoteServiceRelativePath("sortTable")
public interface SortService extends RemoteService {
    ArrayList<Book> sortTable();
}
