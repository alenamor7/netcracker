package com.netcraker.library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing extends JFrame {

    public Swing() {
        super("My library");
        setSize(800, 250);
        setLocation(150, 100);
        setDefaultCloseOperation( EXIT_ON_CLOSE );
        setBackground(Color.lightGray);
        BookModel model = new BookModel();
        JTable table = new JTable(model);
        JScrollPane jScrollPane=new JScrollPane(table);
        add(jScrollPane);


        JButton add = new JButton("Add");
        add.setBackground(Color.lightGray);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddAndEditFrame(model);
            }
        });


        JButton remove = new JButton("Delete");
        remove.setBackground(Color.lightGray);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() != -1 ) {
                    int index = table.getSelectedRow();
                    new RemoveFrame(index, model);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Press the book you want to remove");
                }
            }
        });


        JButton edit = new JButton("Edit");
        edit.setBackground(Color.lightGray);
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() != -1) {
                    int index = table.getSelectedRow();
                    new AddAndEditFrame(index, model);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Press the book you want to edit");
                }
            }
        });

        JPanel panels = new JPanel();  //panel for buttons
        panels.add(add);
        panels.add(edit);
        panels.add(remove);
        add(panels, "South");

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
            }
        });
    }
}
