package com.rating;

import java.awt.Font;
import java.io.IOException;
import java.io.Serial;
import java.util.Locale;
import java.util.logging.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterSwingGui extends JFrame {
    @Serial
    private static final long serialVersionUID = 1L;
    private final JTextField name;
    private final JTextField surname;
    private final JTextField username;
    private final JPasswordField passwordField;
    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public RegisterSwingGui()  {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1000,600);
        setTitle("Register with Swing");

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New User Register - Delete");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewUserRegister.setBounds(58, 52, 600, 50);
        contentPane.add(lblNewUserRegister);

        /* NAME */
        JLabel lblName = new JLabel("NAME");
        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblName.setBounds(58, 152, 150, 43);
        contentPane.add(lblName);

        /* NAME INPUT */
        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        name.setBounds(214, 151, 228, 50);
        contentPane.add(name);
        name.setColumns(10);

        /* SURNAME */
        JLabel lblSurname = new JLabel("SURNAME");
        lblSurname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblSurname.setBounds(58, 243, 110, 29);
        contentPane.add(lblSurname);

        /* SURNAME INPUT */
        surname = new JTextField();
        surname.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        surname.setBounds(214, 235, 228, 50);
        contentPane.add(surname);
        surname.setColumns(10);

        /* USERNAME */
        JLabel lblUsername = new JLabel("USERNAME");
        lblUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblUsername.setBounds(542, 151, 160, 36);
        contentPane.add(lblUsername);

        /* USERNAME INPUT */
        username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        /* PASSWORD */
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        lblPassword.setBounds(542, 245, 99, 24);
        contentPane.add(lblPassword);

        /* PASSWORD INPUT */
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        passwordField.setBounds(707, 235, 228, 50);
        contentPane.add(passwordField);

        JButton btnDelete = new JButton("Delete Record");
        btnDelete.addActionListener(e -> {
            RegisterUserDao registerUserDao = new RegisterUserDao();
            RegisterUser registerUser = registerUserDao.getRegisteredUserByUsername(username.getText());
            if (registerUser != null){
                registerUserDao.deleteRegisteredUser(registerUser.getId());
                JOptionPane.showMessageDialog(btnDelete,
                        username.getText() + ", is sucessfully created");
            }
                });

        btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnDelete.setBounds(100, 447, 259, 74);
        contentPane.add(btnDelete);


        JButton btnUserRegister = new JButton("Register");
        btnUserRegister.addActionListener(e -> {

            RegisterSwingGui.logger();

            LOGGER.info("REGISTER BUTTON IS CLICKED");

            /* I used constructor for assign values*/
            RegisterUser registerUser = new RegisterUser(name.getText(),surname.getText(),username.getText(),passwordField.getText());

            LOGGER.info("VARIABLES SENT TO CONSTRUCTOR");

            RegisterUserDao registerUserDao = new RegisterUserDao();

            LOGGER.info( "Data Access Object IS CREATED");

            try {
                /* Add new record*/
                registerUserDao.saveRegisteredUser(registerUser);
            }catch (Exception exp){
                LOGGER.severe("PROBLEM WITH DATABASE, RECORD NOT ADDED");
            }

            LOGGER.warning( "NEW RECORD IS ADDED TO DATABASE");

            /* Update the Name and Surname from database to the UpperCase */
            registerUser.setName(registerUser.getName().toUpperCase(Locale.ROOT));
            registerUser.setSurname(registerUser.getSurname().toUpperCase(Locale.ROOT));

            LOGGER.warning("NAME AND SURNAME IS UPDATED TO THE UPPER CASE");

            registerUserDao.updateRegisteredUser(registerUser);

            JOptionPane.showMessageDialog(btnUserRegister,
                    "Welcome, " + name.getText() + "Your account is sucessfully created");
        });
        btnUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnUserRegister.setBounds(399, 447, 259, 74);
        contentPane.add(btnUserRegister);

    }
    public static void logger(){
        /* Clean the root handler which is console*/
        LogManager.getLogManager().reset();

        /* Global switch for all others handlers*/
        LOGGER.setLevel(Level.ALL);

        /* Handler for console */
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        LOGGER.addHandler(consoleHandler);

        try {

            /* File Handler*/
            FileHandler fileHandler = new FileHandler("logger.txt",true);
            fileHandler.setLevel(Level.FINEST);
            LOGGER.addHandler(fileHandler);
        } catch (IOException ex) {
            ex.printStackTrace();
            LOGGER.log(Level.SEVERE, "File logger not working",ex);
        }
    }
}