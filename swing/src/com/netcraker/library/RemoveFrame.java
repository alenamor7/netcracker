package com.netcraker.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveFrame extends JFrame {
    public RemoveFrame(int index, BookModel model){
        super("Deleting Book");
        setSize(250, 150);
        setLocation(450, 300);
        setBackground(Color.lightGray);
        setLayout( new GridLayout(0, 1));

        JPanel question = new JPanel();
        JLabel q = new JLabel("Do you want to delete this book?");
        question.add(q);
        JPanel choice = new JPanel();
        JButton yes = new JButton("Yes");
        yes.setBackground(Color.lightGray);
        yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookModel library = new BookModel();
                library.deleteBook(index);
                dispose();
                model.readFile();
            }
        });
        JButton no = new JButton("No");
        no.setBackground(Color.lightGray);
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        choice.add(yes);
        choice.add(no);
        add(question);
        add(choice);

        setVisible(true);
    }
}
