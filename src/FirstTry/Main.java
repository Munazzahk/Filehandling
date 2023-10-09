package FirstTry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

//Go to the three dots, edit configuration and add 'src' to path
//When creating new file, add package name with the filename
//Yout file will now be added to your package

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        File file = new File("FirstTry//newFile.txt");

        try {
            PrintStream ps = new PrintStream(file);
            ps.println("Hej");
            ps.close();
        } catch (FileNotFoundException e) {
            System.out.println("An exception has occured");
        }

    }
}