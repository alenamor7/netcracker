package com.netcracker.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.netcracker.shared.Book;

import java.util.ArrayList;

public interface SortServiceAsync {
    void sortTable(AsyncCallback<ArrayList<Book>> callback);
}
