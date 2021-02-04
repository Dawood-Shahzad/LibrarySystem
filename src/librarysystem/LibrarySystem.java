package librarysystem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<borrowers> borrowerList = new ArrayList<>();
    
    public static void main(String[] args) {
        bookList = filehandling.readFile();
        borrowerList = filehandling2.readFile();
        System.out.println("Welcome to my library, what would you like to do");
        while (true) {
        System.out.println("1 - go to book menu");
        System.out.println("2 - go to borrowers menu");
        System.out.println("0 - exit");
        int userChoice = input.nextInt();
        
        switch (userChoice) {
            case 1:
                mainMenu1();
                break;
            case 2:
                mainMenu2();
                break;
            case 0:
                System.exit(0);
            }
        mainMenu1();
        mainMenu2();
        }
    }

    public static void mainMenu1() {
        System.out.println("Choose an option");
        while (true) {
            System.out.println("What would you like to do");
            System.out.println("1 - Add a new book");
            System.out.println("2 - View all books");
            System.out.println("3 - Edit a book");
            System.out.println("4 - Delete a book");
            System.out.println("5 - Go to borrowers menu");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    viewAllBooks();
                    break;
                case 3:
                    editBooks();
                    break;
                case 4:
                    deleteBooks();
                    break;
                case 5:
                    mainMenu2();
                    break;
                case 0:
                    filehandling.writeFile(bookList);
                    System.exit(0);
            }
        }
    }
    
    public static void mainMenu2(){
        System.out.println("Choose an option");
        while (true) {
            System.out.println("What would you like to do");
            System.out.println("1 - Add a new borrower");
            System.out.println("2 - View all borrowers");
            System.out.println("3 - Edit a borrower");
            System.out.println("4 - Delete a borrower");
            System.out.println("5 - Go to book menu");
            System.out.println("0 - Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    addBorrower();
                    break;
                case 2:
                    viewAllBorrower();
                    break;
                case 3:
                    editBorrower();
                    break;
                case 4:
                    deleteBorrower();
                    break;
                case 5:
                    mainMenu1();
                    break;
                case 0:
                    filehandling2.writeFile(borrowerList);
                    System.exit(0);
            }
        }
    }
    
    public static void addBook() {
        System.out.println("Please type in a name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in a ISBN");
        String ISBN = input.nextLine();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in a author");
        input.nextLine();
        String author = input.nextLine();
        System.out.println("Please type in a genre");
        String genre = input.nextLine();
        Book mybook = new Book(name, ISBN, price, author, genre);
        bookList.add(mybook);
    }

    public static void viewAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("Sorry there are no books in the library right now");

        } else {
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println(bookList.get(i).toString());
            }
        }
    }

    public static void editBooks() {
        int index = getBookIndex();
        
        if (index == -1) {
            System.out.println("Sorry, this is not a valid book");
        } else {
            System.out.println("What would you like to edit");

            System.out.println("1 - name");
            System.out.println("2 - ISBN");
            System.out.println("3 - price");
            System.out.println("4 - author");
            System.out.println("5 - genre");
            System.out.println("6 - none of these, never mind");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please type in the new name");
                    input.nextLine();
                    String newname = input.nextLine();
                    bookList.get(index).setName(newname);
                    break;
                case 2:
                    System.out.println("Please type in the new ISBN");
                    input.nextLine();
                    String newISBN = input.nextLine();
                    bookList.get(index).setISBN(newISBN);
                    break;
                case 3:
                    System.out.println("Please type in the new price");
                    double newprice = input.nextDouble();
                    bookList.get(index).setPrice(newprice);
                    break;
                case 4:
                    System.out.println("Please type in the new author");
                    input.nextLine();
                    String newauthor = input.nextLine();
                    bookList.get(index).setAuthor(newauthor);
                    break;
                case 5:
                    System.out.println("Please type in the new ganre");
                    input.nextLine();
                    String newgenre = input.nextLine();
                    bookList.get(index).setGenre(newgenre);
                    break;
                case 6:
                    break;
            }
            System.out.println("Book successfully chnged to" + bookList.get(index).toString());
        }

    }

    public static void deleteBooks() {
        int index = getBookIndex();
        if (index == -1) {
            System.out.println("Sorry, this is not a valid book");
        } else {
            bookList.remove(index);
        }
    }
    
    public static int getBookIndex() {
        System.out.println("Please type in the book name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in the ISBN");
        String ISBN = input.nextLine();

        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getName().equals(name) && bookList.get(i).getISBN().equals(ISBN)) {
                return i;

            }
        }
        return -1;

    }
    
    public static void addBorrower() {
     System.out.println("Please type in the borrowers name");
        input.nextLine();
        String borrowersname = input.nextLine();
        System.out.println("Please type in the amount of books borrowed");
        String borrowedamount = input.nextLine();
        System.out.println("Please type in the borrowers email");
        String borrowersemail = input.nextLine();
        System.out.println("Please type in the date");
        double date = input.nextDouble();
        borrowers myborrowers = new borrowers(borrowersname, borrowedamount, borrowersemail, date);
        borrowerList.add(myborrowers);

}
    
    public static void viewAllBorrower(){
        if (borrowerList.isEmpty()) {
            System.out.println("Sorry there are no borrowers in the library system right now");

        } else {
            for (int i = 0; i < borrowerList.size(); i++) {
                System.out.println(borrowerList.get(i).toString());
            }
        }
    }
    
    public static void editBorrower(){
        int index = getBorrowersIndex();
        
        if (index == -1) {
            System.out.println("Sorry, this is not a valid borrower");
        } else {
            System.out.println("What would you like to edit");

            System.out.println("1 - borrowers name");
            System.out.println("2 - borrowed amount");
            System.out.println("3 - borrowers email");
            System.out.println("4 - date");
            System.out.println("5 - none of these, never mind");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please type in the new borrowers name");
                    input.nextLine();
                    String newborrowersname = input.nextLine();
                    bookList.get(index).setBorrowersname(newborrowersname);
                    break;
                case 2:
                    System.out.println("Please type in the new borrowed amount");
                    input.nextLine();
                    String newborrowedamount = input.nextLine();
                    bookList.get(index).setBorrowedamount(newborrowedamount);
                    break;
                case 3:
                    System.out.println("Please type in the new borrowers email");
                    input.nextLine();
                    String newborrowersemail = input.nextLine();
                    bookList.get(index).setBorrowersemail(newborrowersemail);
                    break;
                case 4:
                    System.out.println("Please type in the new date");
                    double newdate = input.nextDouble();
                    bookList.get(index).setDate(newdate);
                    break;
                case 5:
                    break;
            }
            System.out.println("Borrower has been successfully chnged to" + borrowerList.get(index).toString());
        }

    }
    
    public static void deleteBorrower(){
        int index = getBorrowersIndex();
        if (index == -1) {
            System.out.println("Sorry, this is not a valid borrower");
        } else {
            borrowerList.remove(index);
        }
    }
    
    public static int getBorrowersIndex(){
        System.out.println("Please type in the borrowers name");
        input.nextLine();
        String borrowersname = input.nextLine();
        System.out.println("Please type in the borrowers email");
        String borrowersemail = input.nextLine();

        for (int i = 0; i < borrowerList.size(); i++) {
            if (borrowerList.get(i).getBorrowersname().equals(borrowersname) && borrowerList.get(i).getBorrowersemail().equals(borrowersemail)) {
                return i;

            }
        }
        
        return -1;
    }
    
}