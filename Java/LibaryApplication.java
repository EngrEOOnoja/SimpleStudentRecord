import java.util.ArrayList;
import java.util.Scanner;

public class LibraryTracker {

    static ArrayList<String> titles = new ArrayList<>();
    static ArrayList<Boolean> available = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBooks();

        while (true) {
            showMenu();
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                showBooks();
            } else if (choice.equals("2")) {
                borrowBook();
            } else if (choice.equals("3")) {
                returnBook();
            } else if (choice.equals("4")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    }

    public static void initializeBooks() {
        titles.add("Things Fall Apart - Chinua Achebe");
        titles.add("Half of a Yellow Sun - Chimamanda Ngozi Adichie");
        titles.add("Americanah - Chimamanda Ngozi Adichie");
        titles.add("The Famished Road - Ben Okri");
        titles.add("Purple Hibiscus - Chimamanda Ngozi Adichie");
        titles.add("Cry, the Beloved Country - Alan Paton");
        titles.add("Nervous Conditions - Tsitsi Dangarembga");
        titles.add("Disgrace - J.M. Coetzee");
        titles.add("The Joys of Motherhood - Buchi Emecheta");
        titles.add("So Long a Letter - Mariama Bâ");

        for (int bookIndex = 0; bookIndex < titles.size(); bookIndex++) {
            available.add(true);
                    }
    }

    public static void showMenu() {
        System.out.println("\nLibrary Book Tracker");
        System.out.println("1. View all books");
        System.out.println("2. Borrow a book");
        System.out.println("3. Return a book");
        System.out.println("4. Exit");
    }

    public static void showBooks() {
        System.out.println("\nBooks List:");
        for (int index = 0; index < titles.size(); index++) {
            String status = available.get(index) ? "Available" : "Borrowed";
            System.out.println((index + 1) + ". " + titles.get(index) + " - " + status);
        }
    }

    public static void borrowBook() {
        showBooks();
        System.out.print("Enter the number of the book to borrow: ");
        String input = scanner.nextLine();
        int index = toInteger(input) - 1;

        if (index >= 0 && index < titles.size()) {
            if (available.get(index)) {
                available.set(index, false);
                System.out.println("You borrowed \"" + titles.get(index) + "\"");
            } else {
                System.out.println("Sorry, \"" + titles.get(index) + "\" is already borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

    public static void returnBook() {
        showBooks();
        System.out.print("Enter the number of the book to return: ");
        String input = scanner.nextLine();
        int index = toInteger(input) - 1;

        if (index >= 0 && index < titles.size()) {
            if (!available.get(index)) {
                available.set(index, true);
                System.out.println("You returned \"" + titles.get(index) + "\"");
            } else {
                System.out.println("\"" + titles.get(index) + "\" was never borrowed.");
            }
        } else {
            System.out.println("Invalid book number.");
        }
    }

       public static int toInteger(String str) {
        int number = 0;
        for (int count = 0; count < str.length(); count++) {
            char ch = str.charAt(count);
            if (ch >= '0' && ch <= '9') {
                number = number * 10 + (ch - '0');
            } else {
                return -1;
            }
        }
        return number;
    }
}
