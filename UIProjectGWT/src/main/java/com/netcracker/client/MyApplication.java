package com.netcracker.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.netcracker.shared.Author;
import com.netcracker.shared.Book;



import java.util.ArrayList;
import java.util.Date;


public class MyApplication implements EntryPoint {
    TextBox id = new TextBox();
    TextBox title = new TextBox();
    TextBox authorName = new TextBox();
    TextBox authorSurname = new TextBox();
    TextBox pages = new TextBox();
    TextBox publishYear = new TextBox();


    Button addButton = new Button("Add book");
    Button deleteButton = new Button("Delete book");
    Button sortByTitleButton = new Button("Sort by title");
    HorizontalPanel buttons = new HorizontalPanel();

    CellTable<Book> table ;

    HorizontalPanel addBookPanel = new HorizontalPanel();
    VerticalPanel idPanel = new VerticalPanel();
    VerticalPanel titlePanel = new VerticalPanel();
    VerticalPanel namePanel = new VerticalPanel();
    VerticalPanel surnamePanel = new VerticalPanel();
    VerticalPanel pagesPanel = new VerticalPanel();
    VerticalPanel yearPanel = new VerticalPanel();

    VerticalPanel wholePage = new VerticalPanel();

    Label idLabel = new Label("Id");
    Label titleLabel = new Label("Title");
    Label nameLabel = new Label("Author's name");
    Label surnameLabel = new Label("Author's surname");
    Label pagesLabel = new Label("Pages");
    Label yearLabel = new Label("Publish year");

    ArrayList<Book> lib = new ArrayList<>();
    //Panel panel = paint();

    private static ReadFileServiceAsync readFileService =
            GWT.create(ReadFileService.class);
    private static AddBookServiceAsync addBookService =
            GWT.create(AddBookService.class);
    private static DeleteBookServiceAsync deleteBookService =
            GWT.create(DeleteBookService.class);
    private static SortServiceAsync sortService =
            GWT.create(SortService.class);

    private class AddBookCallback implements AsyncCallback {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());
        }

        @Override
        public void onSuccess(Object result) {
            table.removeFromParent();
            paint();
        }
    }

    private class DeleteBookCallback implements AsyncCallback {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());
        }

        @Override
        public void onSuccess(Object result) {
            table.removeFromParent();
            paint();
        }
    }

    private class ReadFileCallback implements AsyncCallback<ArrayList<Book>> {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());
        }

        @Override
        public void onSuccess(ArrayList<Book> result) {
            lib = result;
            paint();
        }
    }

    private class SortCallback implements AsyncCallback<ArrayList<Book>> {
        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());
        }

        @Override
        public void onSuccess(ArrayList<Book> result) {
            lib = result;
            table.removeFromParent();
            paint();
        }
    }


    public void onModuleLoad() {

        readFileService.readFile(new ReadFileCallback());
        addButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                if(Validation.validation(title, authorName, authorSurname, pages, publishYear)) {
                    Date date = new Date();
                    Book addBook = new Book(Integer.parseInt(id.getText()), new Author(authorName.getText(), authorSurname.getText()), title.getText(), Integer.parseInt(pages.getText()),
                            Integer.parseInt(publishYear.getText()), date );
                    lib.add(addBook);
                    id.setText("");
                    title.setText("");
                    authorName.setText("");
                    authorSurname.setText("");
                    pages.setText("");
                    publishYear.setText("");
                    addBookService.addBook(addBook, new AddBookCallback());

                }

            }
        });

        sortByTitleButton.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                sortService.sortTable(new SortCallback());
            }
        });

    }

    public void getAddBookPanel(){
        id.setSize("130", "30");
        idPanel.add(idLabel);
        idPanel.add(id);

        title.setSize("130", "30");
        titlePanel.add(titleLabel);
        titlePanel.add(title);

        authorName.setSize("130", "30");
        namePanel.add(nameLabel);
        namePanel.add(authorName);


        authorSurname.setSize("130", "30");
        surnamePanel.add(surnameLabel);
        surnamePanel.add(authorSurname);

        pages.setSize("130", "30");
        pagesPanel.add(pagesLabel);
        pagesPanel.add(pages);


        publishYear.setSize("130", "30");
        yearPanel.add(yearLabel);
        yearPanel.add(publishYear);

        addBookPanel.add(idPanel);
        addBookPanel.add(titlePanel);
        addBookPanel.add(namePanel);
        addBookPanel.add(surnamePanel);
        addBookPanel.add(pagesPanel);
        addBookPanel.add(yearPanel);

        addBookPanel.setSpacing(10);

    }

    public void paint(){
        creatingTable();
        getAddBookPanel();
        buttons.add(addButton);
        buttons.add(deleteButton);
        buttons.add(sortByTitleButton);
        buttons.setSpacing(10);
        wholePage.setSpacing(10);
        // page.setBorderWidth(1);
        wholePage.setWidth("400");
        wholePage.add(addBookPanel);
        wholePage.add(buttons);
        wholePage.add(table);
        RootPanel.get("gwtContainer").add(wholePage);
    }


    public void creatingTable() {
        table = new CellTable<Book>();
        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.ENABLED);
        TextColumn<Book> idColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return new Integer(lib.getId()).toString();
            }
        };

        TextColumn<Book> titleColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return lib.getTitle();
            }
        };

        TextColumn<Book> authorNameColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return lib.getAuthor().getName();
            }
        };

        TextColumn<Book> authorSurnameColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return lib.getAuthor().getSurname();
            }
        };

        TextColumn<Book> pagesColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return new Integer(lib.getPages()).toString();
            }
        };

        TextColumn<Book> publishYearColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return new Integer(lib.getPublishYear()).toString();
            }
        };

        TextColumn<Book> dateAddedColumn = new TextColumn<Book>() {
            @Override
            public String getValue(Book lib) {
                return lib.getDateAdded().toString();
            }
        };

        table.addColumn(idColumn, "Id");
        table.addColumn(titleColumn, "Title");
        table.addColumn(authorNameColumn, "Author's name");
        table.addColumn(authorSurnameColumn, "Author's surname");
        table.addColumn(pagesColumn, "pages");
        table.addColumn(publishYearColumn, "Publish year");
        table.addColumn(dateAddedColumn, "Addition date");


        SingleSelectionModel<Book> selectionModel = new SingleSelectionModel<Book>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(
                new SelectionChangeEvent.Handler() {
                    @Override
                    public void onSelectionChange(SelectionChangeEvent event) {
                        Book selectes = selectionModel.getSelectedObject();
                        deleteButton.addClickHandler(new ClickHandler() {
                            @Override
                            public void onClick(ClickEvent event) {
                                if(selectes == null) {
                                    Window.alert("Please, choose book you want to delete");
                                }
                                else{
                                    lib.remove(selectes);
                                    deleteBookService.deleteBook(selectes, new DeleteBookCallback());
                                }
                            }
                        });
                    }
                });


        table.setWidth("100%");
        table.setRowCount(lib.size(), true);
        table.setRowData(0, lib);
    }



}
