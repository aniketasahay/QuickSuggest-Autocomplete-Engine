import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
   public static void main(String[] args) {
        try {
            BufferedReader inputFile = new BufferedReader(new FileReader("ip.txt"));
            List<String> sentences = new ArrayList<>();
            List<Integer> times = new ArrayList<>();

            // Read sentences
            int numSentences = Integer.parseInt(inputFile.readLine().trim());
            for (int i = 0; i < numSentences; i++) {
                sentences.add(inputFile.readLine().trim());
            }

            // Read corresponding times
            for (int i = 0; i < numSentences; i++) {
                times.add(Integer.parseInt(inputFile.readLine().trim()));
            }

            // Create an instance of AutocompleteSystem
            AutoCompleteSystem autocompleteSystem = new AutoCompleteSystem(sentences, times);

            // Process input from the file
            int ch;
            while ((ch = inputFile.read()) != -1) {
                char c = (char) ch;
                List<String> result = autocompleteSystem.input(c);

                // Display autocomplete suggestions
                int count = 1;
                for (String suggestion : result) {
                    System.out.println("Suggestion " + count + ": " + suggestion);
                    count++;
                }
            }

            // Close the input file
            inputFile.close();

        } catch (IOException e) {
            System.err.println("Error opening input file.");
            e.printStackTrace();
        }
   }
}
