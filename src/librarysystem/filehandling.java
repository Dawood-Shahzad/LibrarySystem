package librarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class filehandling {

    private static String folderDirectory = System.getProperty("user.dir") + "\\bookList.txt";

    ;
    static void writeFile(ArrayList<Book> bookList) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < bookList.size(); i++) {
                printToFile.println(bookList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<Book> readFile() {
        ArrayList<Book> bookList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(",");
                Book newBook = new Book(bookDetails[0], bookDetails[1], Double.parseDouble(bookDetails[2]), bookDetails[3], bookDetails[4]);
                bookList.add(newBook);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return bookList;

    }
}
