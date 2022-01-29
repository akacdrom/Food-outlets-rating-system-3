package com.rating;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        while (true)
            userChoice();

    }
    /* Method for user menu*/
    public static void userChoice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1- Register User");
        System.out.println("2- Register Restaurant");
        System.out.println("3- Register Bistro");
        System.out.println("4- Register Take-Away");
        System.out.println("5- Rate Restaurant");
        System.out.println("6- Rate Bistro");
        System.out.println("7- Rate Take-Away");
        System.out.println("8- Delete User");
        System.out.println("9- Delete Restaurant");
        System.out.println("10-Delete Bistro");
        System.out.println("11-Delete Take Away ");
        System.out.println("12-Load Sample File to Database");
        System.out.println("13-Get GUI");
        System.out.print("Enter a number from menu: ");

        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int userInput = scanner.nextInt();

        /*User's request returning the wished method*/
        switch (userInput) {
            case 1 -> setUser();
            case 2 -> createRestaurant();
            case 3 -> createBistro();
            case 4 -> createTakeAway();
            case 5 -> setRatingRestaurant();
            case 6 -> setRatingBistro();
            case 7 -> setRatingTakeAway();
            case 8 -> deleteUser();
            case 9 -> deleteRestaurant();
            case 10-> deleteBistro();
            case 11-> deleteTakeAway();
            case 12-> loadSampleFileToDb();
            case 13-> getGui();
            default -> throw new IllegalStateException("Unexpected value: " + userInput);
        }
    }

    public static void listRestaurant(){
        OutletDao outletDao = new OutletDao();
        List <Restaurant> restaurants = outletDao.getAllRestaurants();
        System.out.println("Listing all registered Restraunts");
        for (Restaurant restaurant:restaurants)
        {
            System.out.println("");
            System.out.println("ID: "+restaurant.getId()+" - NAME:"+restaurant.getName()+" - RATING:"+restaurant.getRating()+" - PRICE:"+restaurant.getPrice()+" - HOURS:"+restaurant.getHours()+" - CITY:"+restaurant.getCity());
        }
        System.out.println("");
    }

    public static void listBistro(){
        OutletDao outletDao = new OutletDao();
        List <Bistro> bistros = outletDao.getAllBistros();
        System.out.println("Listing all registered Bistros");
        for (Bistro bistro:bistros)
        {
            System.out.println("ID: "+bistro.getId()+" - NAME:"+bistro.getName()+" - RATING:"+bistro.getRating()+" - PRICE:"+bistro.getPrice()+" - HOURS:"+bistro.getHours()+" - CITY:"+bistro.getCity());
        }
    }

    public static void listTakeAway(){
        OutletDao outletDao = new OutletDao();

        List <TakeAway> takeAways = outletDao.getAllTakeAways();
        System.out.println("Listing all registered Take Aways");
        for (TakeAway takeAway:takeAways)
        {
            System.out.println("ID: "+takeAway.getId()+" - NAME:"+takeAway.getName()+" - RATING:"+takeAway.getRating()+" - PRICE:"+takeAway.getPrice()+" - HOURS:"+takeAway.getHours()+" - CITY:"+takeAway.getCity());
        }
    }

    public static void setRatingRestaurant(){

        listRestaurant();

        OutletDao outletDao = new OutletDao();
        System.out.print("Enter the Id number of outlet: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int restaurantId = scanner.nextInt();

        Restaurant restaurant = outletDao.getRestaurantById(restaurantId);

        if (!Objects.equals(restaurant.getRating(), "N/A")){
            String [] splitRating = restaurant.getRating().split("_");
            double sumOfRatings = 0;
            for (String s : splitRating) {
                sumOfRatings += Double.parseDouble(s);
            }
            double rating = sumOfRatings/splitRating.length;
            String calculatedRating = String.format("%.2f",rating);

            System.out.println("\n");
            System.out.println("RATING OF "+restaurant.getName()+", IS ---> "+calculatedRating);
        }
        else {
            System.out.print("Enter your rating: ");
            String ratingInput = scanner.next();
            restaurant.setRating(ratingInput);
            outletDao.updateOutlet(restaurant);
            return;
        }

        System.out.print("Enter your rating: ");
        String ratingInput = scanner.next();
        restaurant.setRating(restaurant.getRating()+"_"+ratingInput);
        outletDao.updateOutlet(restaurant);
    }

    public static void setRatingBistro(){

        listBistro();

        OutletDao outletDao = new OutletDao();
        System.out.print("Enter the Id number of outlet: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int bistroId = scanner.nextInt();

        Bistro bistro = outletDao.getBistrotById(bistroId);

        if (!Objects.equals(bistro.getRating(), "N/A")){
            String [] splitRating = bistro.getRating().split("_");
            double sumOfRatings = 0;
            for (String s : splitRating) {
                sumOfRatings += Double.parseDouble(s);
            }
            double rating = sumOfRatings/splitRating.length;
            String calculatedRating = String.format("%.2f",rating);

            System.out.println("\n");
            System.out.println("RATING OF "+bistro.getName()+", IS ---> "+calculatedRating);
        }
        else {
            System.out.print("Enter your rating: ");
            String ratingInput = scanner.next();
            bistro.setRating(ratingInput);
            outletDao.updateOutlet(bistro);
            return;
        }

        System.out.print("Enter your rating: ");
        String ratingInput = scanner.next();
        bistro.setRating(bistro.getRating()+"_"+ratingInput);
        outletDao.updateOutlet(bistro);
    }

    public static void setRatingTakeAway(){
        listTakeAway();

        OutletDao outletDao = new OutletDao();
        System.out.print("Enter the Id number of outlet: ");
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int takeAwayId = scanner.nextInt();

        TakeAway takeAway = outletDao.getTakeAwayById(takeAwayId);

        if (!Objects.equals(takeAway.getRating(), "N/A")){
            String [] splitRating = takeAway.getRating().split("_");
            double sumOfRatings = 0;
            for (String s : splitRating) {
                sumOfRatings += Double.parseDouble(s);
            }
            double rating = sumOfRatings/splitRating.length;
            String calculatedRating = String.format("%.2f",rating);

            System.out.println("\n");
            System.out.println("RATING OF "+takeAway.getName()+", IS ---> "+calculatedRating);
        }
        else {
            System.out.print("Enter your rating: ");
            String ratingInput = scanner.next();
            takeAway.setRating(ratingInput);
            outletDao.updateOutlet(takeAway);
            return;
        }

        System.out.print("Enter your rating: ");
        String ratingInput = scanner.next();
        takeAway.setRating(takeAway.getRating()+"_"+ratingInput);
        outletDao.updateOutlet(takeAway);
    }

    /* Method for create new user*/
    public static void setUser() throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = myObj.nextLine();

        System.out.print("Enter surname: ");
        String surname = myObj.nextLine();

        System.out.print("Enter username: ");
        String username = myObj.nextLine();

        System.out.print("Enter password: ");
        String password = myObj.nextLine();

        /* I used constructor for assign values*/
        RegisterUser registerUser = new RegisterUser(name,surname,username,password);

        RegisterUserDao registerUserDao = new RegisterUserDao();

        /* Add new record*/
        registerUserDao.saveRegisteredUser(registerUser);

        /* Update the Name and Surname from database to the UpperCase */
        registerUser.setName(registerUser.getName().toUpperCase(Locale.ROOT));
        registerUser.setSurname(registerUser.getSurname().toUpperCase(Locale.ROOT));
        registerUserDao.updateRegisteredUser(registerUser);

        System.out.println();

        //registerUser.registerToFile();
    }

    public static void deleteUser(){

        RegisterUserDao registerUserDao = new RegisterUserDao();
        List <RegisterUser> registerUsers = registerUserDao.getAllRegisteredUsers();
        System.out.println("Listing all registered users");
        for (RegisterUser registerUser:registerUsers)
        {
            System.out.println("ID: "+registerUser.getId()+" - NAME:"+registerUser.getName()+" - SURNAME:"+registerUser.getSurname()+" - USERNAME:"+registerUser.getUsername());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the user: ");
        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int userId = scanner.nextInt();
        registerUserDao.deleteRegisteredUser(userId);
    }

    /* Set and return variables taking from user for the registration of new outlet*/
    /* Collection interface "List" is used*/
    public static List<String> setRestaurant() {
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter name of outlet: ");
        String name = myObj.nextLine();

        /* No default rating*/
        String rating = "N/A";

        System.out.print("Enter price range: ");
        String price = myObj.nextLine();

        System.out.print("Enter hours: ");
        String hours = myObj.nextLine();

        System.out.print("Enter City: ");
        String city = myObj.nextLine();

        List<String> list = new ArrayList<>();
        list.add(name);
        list.add(rating);
        list.add(price);
        list.add(hours);
        list.add(city);

        return list;
    }

    /* Next 3 method for create selected outlet*/
    public static void createRestaurant() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        Restaurant restaurant = new Restaurant(getRest[0],getRest[1],getRest[2],getRest[3],getRest[4]);

        OutletDao outletDao = new OutletDao();

        /* Add new record*/
        outletDao.saveOutlet(restaurant);
    }

    public static void createBistro() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        Bistro bistro = new Bistro(getRest[0],getRest[1],getRest[2],getRest[3],getRest[4]);

        OutletDao outletDao = new OutletDao();

        outletDao.saveOutlet(bistro);
    }
    public static void createTakeAway() throws IOException {
        String [] getRest = String.join(",", setRestaurant()).split(",");
        TakeAway takeAway = new TakeAway(getRest[0],getRest[1],getRest[2],getRest[3],getRest[4]);

        OutletDao outletDao = new OutletDao();

        outletDao.saveOutlet(takeAway);
    }

    public static void deleteRestaurant() throws IOException {

        listRestaurant();

        OutletDao outletDao = new OutletDao();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the user: ");
        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int outletId = scanner.nextInt();
        outletDao.deleteRestaurant(outletId);
    }

    public static void deleteBistro() throws IOException {

        listBistro();

        OutletDao outletDao = new OutletDao();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the user: ");
        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int outletId = scanner.nextInt();
        outletDao.deleteBistro(outletId);
    }
    public static void deleteTakeAway() throws IOException {

        listTakeAway();

        OutletDao outletDao = new OutletDao();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Id of the user: ");
        /* Be sure user input is int*/
        while (!scanner.hasNextInt()){
            System.out.println("Input not valid.");
            scanner.nextLine();
        }
        int outletId = scanner.nextInt();
        outletDao.deleteTakeAway(outletId);
    }
    public static void loadSampleFileToDb() throws IOException {
        RegisterUserDao registerUserDao = new RegisterUserDao();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/rating/userInfo"));
        String line;
        System.out.println("FILE IS READING: ");
        while((line = bufferedReader.readLine()) != null) {
            String [] splitted = line.split(",");
            RegisterUser registerUser = new RegisterUser(splitted[0],splitted[1],splitted[2],splitted[3]);
            /* Add new record*/
            registerUserDao.saveRegisteredUser(registerUser);

            System.out.println("NEW RECORD IS ADDED");
            System.out.println("Name: "+splitted[0]+" | "+"Rating: "+splitted[1]+"/10 | "+"Price: "+splitted[2]+" | "+"Hours: "+splitted[3]);
        }
    }
    public static void getGui(){
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    RegisterSwingGui frame = new RegisterSwingGui();
                    frame.setVisible(true);
                }});
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
