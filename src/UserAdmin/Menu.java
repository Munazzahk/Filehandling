package UserAdmin;

import java.util.Scanner;

public class Menu {
    private String menuHeader;
    private String menuText;
    private String[] menuItems;

    public Menu(String menuHeader, String menuText, String[] menuItems) {
        this.menuHeader = menuHeader;
        this.menuItems = menuItems;
        this.menuText = menuText;
    }

    public void printMenu() {
        String printString = menuHeader + "\n";

        for (int i = 0; i < menuItems.length; i++) {
            printString += menuItems[i] + "\n";
        }
        System.out.println("\n" + printString);
    }

    public int readChoice() {
        Scanner in = new Scanner(System.in);
        boolean validChoice = false;
        int choice = -1;

        while (! validChoice) {
            System.out.print(menuItems);
            if (in.hasNextInt()) {
                choice = in.nextInt();
                validChoice = true;
            } else {
                in.nextLine();
            }

        }
        return choice;
    }

}
