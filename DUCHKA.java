package com.mycompany.ex02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DUCHKA {
    private final View view;
    private final Menu menu;

    public DUCHKA(View view) {
        this.view = view;
        this.menu = Menu.getInstance();
    }

    public void menu() {
        JFrame frame = new JFrame("DUCHKA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel commandLabel = new JLabel("Enter command:");
        commandLabel.setBounds(10, 20, 150, 25);
        panel.add(commandLabel);

        JTextField commandField = new JTextField(1);
        commandField.setBounds(170, 20, 25, 25);
        panel.add(commandField);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(200, 20, 80, 25);
        panel.add(submitButton);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(10, 60, 270, 100);
        panel.add(resultArea);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = commandField.getText();
                switch (command) {
                    case "q":
                        resultArea.setText("Exit.");
                        break;
                    case "v":
    view.viewShow(); // Call viewShow() to update the view
    resultArea.setText("View current."); // Set the text without concatenating viewShow()
    break;
                    case "g":
    view.viewInit();
    view.viewShow(); // Оновіть відображення
    resultArea.setText("Випадкове покоління.");
    break;
case "s":
    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("items.bin"))) {
        os.writeObject(view);
        view.viewShow(); // Оновіть відображення
        resultArea.setText("Зберегти поточний стан.");
    } catch (IOException ex) {
        resultArea.setText("Помилка серіалізації: " + ex);
    }
    break;
                    case "r":
                        resultArea.setText("Restore last saved.\n"); // Add functionality for restoring last saved view
                        break;
                    case "c":
                        resultArea.setText("Change item: scale factor\n"); // Add functionality for changing item
                        break;
                    case "e":
                        menu.executeLastCommand();
                        resultArea.setText("Execute last command.\n");
                        break;
                    default:
                        resultArea.setText("Wrong command.");
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        DUCHKA duchka = new DUCHKA(new ViewResult());
        duchka.menu();
    }
}
