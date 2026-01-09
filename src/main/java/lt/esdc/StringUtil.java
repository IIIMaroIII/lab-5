package lt.esdc;

import java.util.Scanner;

public class StringUtil {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();
        stringUtil.initSplitWords();


    }

    public void initSplitWords() {
        // task 2
        System.out.println(BLUE + "❇️ You have 5 attempts ❇️" + RESET);
        int counter = 0;
        while (counter <= 5) {
            String[] res = splitWords();
            if (res != null) {
                printOutStringArray(res, BLUE + " 👉 " + RESET);
                counter += 1;
                continue;
            }
            System.out.println(BLUE + "⚠️ The array is empty or contained only separators ⚠️" + RESET);

        }
    }

    public void initCountEqualIgnoreCaseAndSpaces() {
        // task1
        String result = countEqualIgnoreCaseAndSpaces();
        printOutStringCommaSeparated(result);
    }

    public static String countEqualIgnoreCaseAndSpaces() {
        String input = getValidatedString(GREEN + "👉Enter the sample word/s with a space/s between each one:" + RESET);
        String template = "     countEqualIgnoreCaseAndSpaces Method Method ;;;; :::: ())))) \\\\ signature //// : public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) Return the number of words from words array that are equal to sample ignoring characters case and leading and trailing spaces. If sample is null or words is null or empty, return 0. words is guaranteed to not contain null values.) ";
        String rgx = "\\W+";

        String[] wordsArr = splitIntoStringArr(template, rgx);
        String[] inputWordsArr = splitIntoStringArr(input, rgx);

        StringBuilder output = new StringBuilder();

        for (String inputWord : inputWordsArr) {
            int counter = 0;
            for (String word : wordsArr) {
                if (inputWord.equals(word)) {
                    counter += 1;
                }
            }
            output.append("The word <" + inputWord + "> appeared <" + counter + "> times,");
        }
        return output.toString();
    }

    public static String[] splitWords() {
        String input = getValidatedString(GREEN + "👉Enter the text using following separating characters [,.;: ?!]" + RESET);
        String[] wordsArr = splitIntoStringArr(input, "[\\s,.;:?!]+");

        if (wordsArr.length == 0) {
            return null;
        }

        for (String word : wordsArr) {
            if (word == null || word.equals("null")) return null;
        }

        return wordsArr;
    }

    public static String joinWords() {
        StringBuilder stringBuilder = new StringBuilder();
        String input = getValidatedString(GREEN + "👉 Enter a words to formulate an array" + RESET);

        return stringBuilder.toString();
    }

    public static String[] splitIntoStringArr(String str, String regex) {
        return str.strip().toLowerCase().split(regex);
    }

    public static void printOutStringCommaSeparated(String str) {
        String[] arr = str.strip().split(",");
        for (String sentence : arr) {
            System.out.println(BLUE + sentence + RESET);
        }
    }

    public static void printOutStringArray(String[] arr, String msg) {
        for (String one : arr) {
            System.out.println(GREEN + msg + BLUE + one + RESET);
        }
    }

    public static String getValidatedString(String startMsg) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(startMsg);
            String userInput = scanner.nextLine().strip();

            if (userInput.isBlank()) {
                System.out.println("❌" + RED + "The input is blank, try again" + RESET);
                continue;
            }

            boolean isInt = userInput.matches("^[+-]?\\d+$");
            if (isInt) {
                System.out.println("❌" + RED + "The input has to be a string, try again" + RESET);
                continue;
            }

            return userInput;
        }
    }
}