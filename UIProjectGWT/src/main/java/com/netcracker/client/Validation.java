package com.netcracker.client;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.TextBox;

public class Validation  {
    public static boolean validation(TextBox title, TextBox authorName,TextBox authorSurname, TextBox pages, TextBox publishYear) {
        String titleText = title.getText();
        String nameText = authorName.getText();
        String surnameText = authorSurname.getText();
        String pageText = pages.getText();
        String yearText = publishYear.getText();
        if(titleText == "") {
            Window.alert("Please, enter book's title");
            return false;
        }
        if(nameText.equals("")){
            Window.alert("Please, enter author's name");
            return false;
        }
        if(surnameText.equals("")) {
            Window.alert("Please, enter author's surname");
            return false;
        }
        if(pageText.equals("")) {
            Window.alert("Please, enter quantity of pages");
            return false;
        }
        if(yearText.equals("")) {
            Window.alert("Please, enter book's publish year");
            return false;
        }
        try{
            Integer.parseInt(pageText);
        }catch(NumberFormatException ex) {
            Window.alert("Please, enter integer number in pages field");
            return false;
        }
        try{
            Integer.parseInt(yearText);
        }catch(NumberFormatException ex) {
            Window.alert("Please, enter integer number in publish year field");
            return false;
        }

        return true;
    }
}
