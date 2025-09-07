import java.util.Random;
import java.util.Scanner;

public class TypingSpeedTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        String paragraph = generateRandomParagraph();
        System.out.println("\nType the following paragraph:\n");
        System.out.println(paragraph + "\n");

        
        System.out.println("Press Enter when you're ready to start typing...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        String userInput = scanner.nextLine();
        long endTime = System.currentTimeMillis();

        double timeInSeconds = (endTime - startTime) / 1000.0;

        System.out.println("\n--- Typing Results ---");
        System.out.printf("Time taken: %.2f seconds\n", timeInSeconds);

        double accuracy = calculateTypingAccuracy(paragraph, userInput);
        System.out.printf("Typing Accuracy: %.2f%%\n", accuracy);
    }

    public static String generateRandomParagraph() {
        String[] sentences = {
            "The sun sets behind the hills of Kano.",
            "Children laugh and run across the dusty road.",
            "A gentle breeze moves through the tall grass.",
            "Books were scattered across the classroom floor.",
            "The old man told stories under the baobab tree.",
            "Markets in the city buzz with life every morning.",
            "Aisha loves reading novels by African authors.",
            "Thunder rumbled as rain started to fall.",
            "Faisal rode his bicycle down the empty street.",
            "Birds chirped loudly in the early morning light."
        };

        int numberOfSentences = 3;
        StringBuilder paragraph = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < numberOfSentences; i++) {
            int index = rand.nextInt(sentences.length);
            paragraph.append(sentences[index]).append(" ");
        }

        return paragraph.toString();
    }

    public static double calculateTypingAccuracy(String original, String typed) {
        int correctChars = 0;
        int minLength = Math.min(original.length(), typed.length());

        for (int index = 0; index < minLength; index++) {
            if (original.charAt(index) == typed.charAt(index)) {
                correctChars++;
            }
        }

        
        return ((double) correctChars / original.length()) * 100;
    }
}

