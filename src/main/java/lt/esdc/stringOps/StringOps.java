package lt.esdc.stringOps;

import java.util.ArrayList;

public class StringOps {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        new StringOps().init();
    }

    public void init() {
//        determineRepeatableWords();
//        upperFirstLetters();
        countAndSortWordsByTotalOccurrences();
    }

    public void determineRepeatableWords() {
        String input = "Sun  Sun Sun Sun shines shines sun bright bright ".toLowerCase().trim();
        String[] arr = input.toLowerCase().split("\\W+");
        StringBuilder result = new StringBuilder();

        int counter = 0;
        for (String word : arr) {
            for (String eachWord : arr) {

                if (word.equals(eachWord)) {
                    counter++;
                }
            }
            if (counter % 2 != 0) {
                System.out.format(GREEN + "✅ The word %s has occurred %d times\n", word, counter);
                return;
            }

        }
        System.out.println(RED + "⚠️ We haven't found any even occurrences.\n");

    }

    public void upperFirstLetters() {
        String input = "  Sun Sun Sun  shines sun bright shines bright".toLowerCase().trim();

        String[] arr = input.split("\\s+");
        String[] result = new String[arr.length];

        int i = 0;
        for (String word : arr) {
            char firstUpperCaseLetter = Character.toUpperCase(word.charAt(0));
            String newWord = word.replaceFirst("^\\w", String.valueOf(firstUpperCaseLetter));
            result[i] = newWord;
            i++;
        }

        System.out.println(GREEN + "👉 A given string: " + BLUE + input);
        System.out.println(GREEN + "🏁 Result: " + BLUE + String.join(" ", result));
    }

    //The city wakes up when the sun lights the streets and the houses. People leave their houses, and the sun continues to shine over the city.
    public void countAndSortWordsByTotalOccurrences() {
        String text = "The sun shines brightly over the city, and the sun rises above the buildings.".toLowerCase().trim();
        String listOfWords = "sun the city houses people streets".toLowerCase().trim();
        String[] arrFromText = text.split("\\W+");
        String[] arrFromWordsList = listOfWords.split("\\W+");

        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

        for (String wordInText : arrFromText) {
            ArrayList<String> listOfRepeatedWords = new ArrayList<String>();
            for (String wordInListOfWords : arrFromWordsList) {
                if (wordInText.equals(wordInListOfWords)) listOfRepeatedWords.add(wordInText);
            }

        }


    }
}