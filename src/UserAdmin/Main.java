package UserAdmin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<User> users;
    public static void main(String[] args) {
        new Main().run();
    }

    Main() {
        users = new ArrayList<User>();
        readFile();
    }

    private void run() {
        boolean running;
        Menu menu = new Menu("Menu", "Please choose an option: ",
                new String[] {
                        "1. View user list",
                        "2. Create new user",
                        "3. Delete user",
                        "9. Quit"
                });

        readFile();;

        running = true;
        while (running) {
            menu.printMenu();
            int userChoice = menu.readChoice();

            switch (userChoice) {
                case 1 -> viewUserList();
                case 2 -> createNewUser();
                case 3 -> deletUser();
                case 9 -> running = false;
                default -> System.out.println("Illegal choice");
            }
        }


    }

    private void viewUserList() {
        System.out.println("\n User List: ");
        for (int i = 0; i < users.size(); i++) {
            System.out.println("#" + i + ": " + users.get(i));
        }
    }

    private void createNewUser() {
        int id;
        String name;
        String password;
        User user;
        Scanner in = new Scanner(System.in);

        System.out.println("\n Create a new user: ");

        System.out.println("Id: ");
        id = in.nextInt();
        in.nextLine(); //Scanner bug

        System.out.println("Name: ");
        name = in.nextLine();

        System.out.println("Password: ");
        password = in.nextLine();

        user = new User(id, name, password);
        users.add(user);
        saveFile();
        System.out.println("\nUser added");
    }

    private void deletUser() {
        int userNumber;
        Scanner in = new Scanner(System.in);

        System.out.println("Delete user: ");
        System.out.println("Enter # of user: ");
        userNumber = in.nextInt();
        in.nextLine(); //Scanner bug

        users.remove(userNumber);
        saveFile();
        System.out.println("\n User deletes");
    }

    private void readFile() {
        Scanner fileScanner = null;
        try {

            //Tell it which file we need to read through scanner
            fileScanner = new Scanner(new File("FirstTry//newFile.txt"));

            //Tell scanner to peek through the file to see when the file is done
            while (fileScanner.hasNextLine()) {
                String s = fileScanner.nextLine();

                //Print all the lines of the file
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileScanner.close();
    }

    private void saveFile() {

    }






}
