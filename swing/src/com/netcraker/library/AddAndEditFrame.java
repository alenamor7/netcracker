package com.netcraker.library;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAndEditFrame extends JFrame {  //AddAndEditFrame has methods and

    JTextField nameText, authorNameText, authorCountryText, yearText, priceText, qtyText;
    JRadioButton male, female;   //radiobutton for gender
    JPanel button;  //panel for button("add" or "edit")

    String genre[] = new String []{    //array of genres, which is used in ComboBox
            "autobiography",  "children's books", "cook-books", "dictionary", "encyclopedia", "fairytale","fantasy",
            "fiction", "history", "horror", "medicine", "non-fuction", "poems", "politics", "religious", "romance",
            "science-fiction", "series", "thriller", "travel books", "other"};
    JComboBox genreCombobox;


    public AddAndEditFrame(BookModel model){   //constructor to ADD a book
        setTitle("Add book");
        setAddFields();   //initialization of all fields in AddFrame(all fields should be empty)
        paint();    //painting frame with all components
        setAddButton(model);   //set button "Add book" with actionListener
    }

    public AddAndEditFrame(int index, BookModel model) {   //constructor to EDIT a book
        setTitle("Edit book");
        setEditFields(index, model);   //initialization of all fields in EditFrame(all fields should be filled with info of edited book)
        paint();    //painting frame with all components
        setEditButton(index, model);   //set button "Edit book" with actionListener
    }


    public void paint() {
        setSize(450, 350);
        setLocation(450, 300);
        setLayout( new GridLayout(0, 1));
        setBackground(Color.lightGray);

        JPanel namePanel = new JPanel(); //
        namePanel.add(new JLabel("Book's title: "));
        namePanel.add(nameText);
        add(namePanel);

        JPanel authorNamePanel = new JPanel();
        authorNamePanel.add(new JLabel("Author's name: "));
        authorNamePanel.add(authorNameText);
        add(authorNamePanel);

        JPanel authorGender = new JPanel();
        authorGender.add(new JLabel("Author's gender: "));
        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);
        authorGender.add(male);
        authorGender.add(female);
        add(authorGender);

        JPanel authorCountry = new JPanel();
        authorCountry.add(new JLabel("Author's country: "));
        authorCountry.add(authorCountryText);
        add(authorCountry);

        JPanel genrePanel = new JPanel();
        genrePanel.add(new JLabel("Genre of book: "));
        genreCombobox.setEditable(true);
        genrePanel.add(genreCombobox);
        add(genrePanel);

        JPanel yearPanel = new JPanel();
        yearPanel.add(new JLabel("Year of book's publication: "));
        yearPanel.add(yearText);
        add(yearPanel);

        JPanel pricePanel = new JPanel();
        pricePanel.add(new JLabel("Price of book: "));
        pricePanel.add(priceText);
        add(pricePanel);

        JPanel qtyPanel = new JPanel();
        qtyPanel.add(new JLabel("Quantity of books: "));
        qtyPanel.add(qtyText);
        add(qtyPanel);

        button = new JPanel();

        setVisible(true);
        add(button);
    }

    //initialization of all fields in AddFrame(all fields should be empty)
    public void setAddFields() {
        nameText = new JTextField(30);
        authorNameText = new JTextField(28);
        authorCountryText = new JTextField(27);
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        genreCombobox = new JComboBox(genre);
        yearText = new JTextField(22);
        priceText = new JTextField(28);
        qtyText = new JTextField(26);
    }

    //initialization of all fields in EditFrame(all fields should be filled with info of edited book)
    public void setEditFields (int index, BookModel model) {
        nameText = new JTextField(model.getBookList().get(index).getName(), 30);
        authorNameText = new JTextField(model.getBookList().get(index).getAuthor().getName(), 30);
        authorCountryText = new JTextField(model.getBookList().get(index).getAuthor().getCountry(),20);
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        if(model.getBookList().get(index).getAuthor().getGender().equals("male")){
            male.setSelected(true);
        }
        else{
            female.setSelected(true);
        }
        genreCombobox = new JComboBox(genre);
        genreCombobox.setSelectedItem(model.getBookList().get(index).getGenre());
        yearText = new JTextField(Integer.toString( model.getBookList().get(index).getYear()),4);
        priceText = new JTextField(Double.toString( model.getBookList().get(index).getPrice()),10);
        qtyText = new JTextField(Integer.toString( model.getBookList().get(index).getQty()),5);
    }

    //set button "Add book" with actionListener
    public void setAddButton(BookModel model) {
        JButton addButton = new JButton("Add book");
        addButton.setBackground(Color.lightGray);
        button.add(addButton);
        add(button);

        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validation()) {
                    model.addBook(createBook());
                    dispose();
                    model.readFile();
                }
            }
        });
    }

    //set button "Save changes" with actionListener
    public void setEditButton(int index, BookModel model) {
        JButton saveButton = new JButton("Save changes");
        saveButton.setBackground(Color.lightGray);
        button.add(saveButton);
        saveButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validation()) {
                    model.editBook(createBook(), index);
                    dispose();
                    model.readFile();
                }
            }
        });
    }

    public boolean validation() {
        if(nameText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please, enter correct book's title");
            return false;
        }
        if(authorNameText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please, enter correct author's name");
            return false;
        }
        if(authorCountryText.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please, enter correct author's country");
            return false;
        }
        if(yearText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please, enter correct year");
            return false;
        }
        if(priceText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please, fill in the fields of price");
            return false;
        }
        if(qtyText.getText().equals("")) {
            JOptionPane.showMessageDialog(nameText, "Please, fill in the field of quantity");
            return false;
        }
        if(!male.isSelected() && !female.isSelected()){
            JOptionPane.showMessageDialog(null, "Please, choose an author's gender");
            return false;
        }
        try{
            Integer.parseInt(yearText.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please, fill in the field of year with integer");
            return false;
        }
        try{
            Double.parseDouble(priceText.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please, fill in the fields of price with number");
            return false;
        }
        try{
            Integer.parseInt(qtyText.getText());
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please, fill in the field of quantity with integer");
            return false;
        }
        if(Integer.parseInt(yearText.getText()) <= 0 ){
            JOptionPane.showMessageDialog(null, "Please, fill in the field of year with  number more than 0");
            return false;
        }
        if(Double.parseDouble(priceText.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Please, fill in the field of price with number more than 0");
            return false;
        }
        if(Integer.parseInt(qtyText.getText()) <=0){
            JOptionPane.showMessageDialog(null, "Please, fill in the field of quantity with number more than 0");
            return false;
        }
        return true;
    }

    public Book createBook() {
        String name = nameText.getText();
        String authorName = authorNameText.getText();
        String authorGender = "";
        if(male.isSelected()) {
            authorGender = "male";
        }
        else if(female.isSelected()) {
            authorGender = "female";
        }
        String authorCountry = authorCountryText.getText();
        String genre = genreCombobox.getSelectedItem().toString();
        int year = Integer.parseInt(yearText.getText());
        double price = Double.parseDouble(priceText.getText());
        int qty = Integer.parseInt(qtyText.getText());
        Author newAuthor = new Author(authorName, authorGender, authorCountry);
        Book newBook = new Book(name, newAuthor, genre, year, price, qty);
        return newBook;
    }

}
