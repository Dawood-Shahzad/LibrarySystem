package librarysystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;


public class filehandling2 {
    private static String folderDirectory = System.getProperty("user.dir") + "\\borrowerList.txt";

    ;
    private static borrowers newborrowers;
    static void writeFile(ArrayList<borrowers> borrowerList) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < borrowerList.size(); i++) {
                printToFile.println(borrowerList.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<borrowers> readFile() {
        ArrayList<borrowers> borrowerList = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] borrowerDetails = lineFromFile.split(",");
                Book newBook = new Book(borrowerDetails[0], borrowerDetails[1], Double.parseDouble(borrowerDetails[2]), borrowerDetails[3], borrowerDetails[4]);
                borrowerList.add(newborrowers);
            }
            read.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return borrowerList;

    }
}


