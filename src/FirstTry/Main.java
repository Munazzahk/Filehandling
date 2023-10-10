package FirstTry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

//Go to the three dots, edit configuration and add 'src' to path
//When creating new file, add package name with the filename
//Yout file will now be added to your package

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        //Create a file instance
        File file = new File("FirstTry//newFile.txt");
        try {
            //Create a prinstream for the file
            PrintStream ps = new PrintStream(file);
            //Write to the file
            ps.println("Hej");
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("An exception has occured");
        }

        //Create a scanner instance
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
}