import java.util.Random;
import java.util.Scanner;

public class RandomParagraphGenerator {
    public static void main(String[] args) {
    
    
    
    }
    
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

        int numberOfSentences = 5; // Number of sentences in the paragraph
        StringBuilder paragraph = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < numberOfSentences; i++) {
            int index = rand.nextInt(sentences.length);
            paragraph.append(sentences[index]).append(" ");
        }

        System.out.println("Random Paragraph:\n");
        System.out.println(paragraph.toString().trim());
    }
}
