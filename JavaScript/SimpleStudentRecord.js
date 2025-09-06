import java.util.ArrayList;
import java.util.Scanner;

public class ArrangeArrray{
	 public static ArrayList<String> studentNames = new ArrayList<>();
	 public static ArrayList<String> studentCourse = new ArrayList<>();
	 public static ArrayList<String> studentAge = new ArrayList<>();
	 public static ArrayList<String> studentAddress = new ArrayList<>();
	 public static ArrayList<String> candidates = new ArrayList<>();
	 public static ArrayList<String> candidates = new ArrayList<>();
	
	
	
	public static void main(String[] args){
		 Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register Candidate party");
            System.out.println("2. Register Voter");
            
            System.out.print("Enter your choice: ");
            String choiceInput = input.nextLine();

            if (!isNumeric(choiceInput)) {
                System.out.println("Invalid input! Please enter a number between 1 and 5.");
                continue;
            }

            int choice = Integer.parseInt(choiceInput);

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid choice. Enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    registerCandidate(input);
                    break;
                case 2:
                    registerVoter(input);
                    break;
                case 3:
                    castVote(input);
                    break;
                case 4:
                    viewResults();
                    break;
                case 5:
                    System.out.println("Exiting........!");
                    System.exit(0);
                    break;
            }
        }
    }
		





}