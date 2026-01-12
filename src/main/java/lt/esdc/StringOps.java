package lt.esdc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOps {
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[34m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static void main(String[] args) {
        // findEvenRepeatableWords
//        String text1 = "Sun sun brIght bright bRigHt shines shines ".strip();
//        String result = findEvenRepeatableWords(text1);
//        System.out.println("👉 Result of findEvenRepeatableWords: " + GREEN + "✅ " + result + " ✅" + RESET);

        // upperFirstLetterOfEachSentence
//        String text2 = ".!@#.$()-.";
//        String result2 = upperFirstLetterOfEachSentence(text2);
//        System.out.println("👉 Result of upperFirstLetterOfEachSentence: " + GREEN + "✅ " + result2 + " ✅" + RESET);

        //countAndSortWordsByTotalOccurrences
        String text3 = "The sun sun sun sun sun sun sun shines brightly over over over the the the city, houses and people, and the sun rises above the buildings as well as. ";
        String listOfWords = " sun !! the";
        String[] result3 = countAndSortWordsByTotalOccurrences(text3, listOfWords);
        printStringArr(result3);

    }


    public static String findEvenRepeatableWords(String str) {
        if (str == null || str.isBlank()) return null;

        String[] wordsArr = str.toLowerCase().strip().split("\\W+");
        int occurrenceCounter = 0;

        for (int i = 0; i < wordsArr.length; i++) {
            if (wordsArr[i].isBlank()) continue;
            occurrenceCounter = 0;
            int idx = -1;

            do {
                int idxOccurrence = str.toLowerCase().indexOf(wordsArr[i], idx + 1);
                idx = idxOccurrence;

                if (idx != -1) {
                    occurrenceCounter++;
                }
            } while (idx >= 0);

            if (occurrenceCounter % 2 == 0) {
                continue;
            }
            return wordsArr[i];
        }
        return null;
    }

    public static String upperFirstLetterOfEachSentence(String str) {
        if (str == null || str.isBlank() || str.matches("\\W+")) return null;
        String[] arr = str.split("\\.+");
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (String sentence : arr) {
            if (sentence.isBlank()) continue;

            String trimmedSentence = sentence.toLowerCase().strip();
            char toUpperFirstChar = Character.toUpperCase(trimmedSentence.charAt(0));
            String newSentence = trimmedSentence.replaceFirst("^\\w", String.valueOf(toUpperFirstChar));
            System.out.println("⚠️ Each sentence: " + sentence);
            System.out.println("⚠️ Trimmed sentence: " + trimmedSentence);
            System.out.println("⚠️ New sentence: " + newSentence);
            result.append(newSentence).append(". ");
            i++;
        }

        return result.toString().strip();


    }

    public static String[] countAndSortWordsByTotalOccurrences(String str, String list) {
        if (str == null || list == null || str.isBlank() || list.isBlank()) return new String[0];

        System.out.println(BLUE + "Original text: " + GREEN + str.strip());
        System.out.println(BLUE + "List of words: " + GREEN + list.strip() + RESET);

        String[] arrFromText = str.toLowerCase().strip().split("\\W+");
        String[] arrFromWordsList = list.toLowerCase().strip().split("\\W+");

        // Counting occurrences
        String[] result = new String[arrFromWordsList.length];
        int i = 0;
        for (String wordFromList : arrFromWordsList) {
            if (wordFromList.isBlank()) continue;
            // Counter for occurrence;
            int occurrencesCounter = 0;

            for (String wordInText : arrFromText) {
                if (wordFromList.equals(wordInText)) {
                    occurrencesCounter++;
                }
            }

            String resultStr = "";
            resultStr = "The word <" + wordFromList + "> occurred in the given text <" + occurrencesCounter + "> times";
            result[i] = resultStr;
            i++;
        }

        // Create a comparator, which will extract the occurrences counter

        Comparator<String> comparator = Comparator.comparingInt((String s) -> {
            String regexQuantityOfTimes = "<(\\d+)>\\s+times";
            Matcher matcher = Pattern.compile(regexQuantityOfTimes).matcher(s);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
            return 0;
        }).reversed();

        Arrays.sort(result, comparator);
        return result;
    }


    public static void printStringArr(String[] arr) {
        if (arr.length == 0) return;
        for (String one : arr) {
            System.out.println("📣 one in many: " + one);
        }

    }

    public static void palindromeSubstr() {
        String input = "In the level notes I found eye, then level, and finally racecar written in bold, eye.";
        System.out.println(BLUE + "Original text: " + GREEN + input);
        String[] arrOfWords = input.toLowerCase().trim().split("\\W+");

        int palindromeCounter = 0;
        String tmp = "";

        for (String word : arrOfWords) {
            int wordLength = word.length();
            int counter = 0;

            for (int i = 0; i < wordLength; i++) {
                char prevSymbol = word.charAt(i);
                char nextSymbol = word.charAt(wordLength - i - 1);
                if (prevSymbol == nextSymbol) counter++;

                // If the word is palindrome;
                if (counter == wordLength && counter > 1) {
                    tmp += word + ",";
                }


            }
        }
        String[] result = tmp.split("\\W+");
        Arrays.sort(result);
        System.out.println(RED + "Sorted array of palindromes: " + Arrays.toString(result) + RESET);
        if (result.length == 0) {
            System.out.println(RED + "❌ We have found none of palindrome in the given text" + RESET);
        }
        String longestPalindrome = result[result.length - 1];
        System.out.format(BLUE + "✅ We have found the longest palindrome %s which is %s chars long", GREEN + longestPalindrome + BLUE, GREEN + longestPalindrome.length() + BLUE);

    }

    public static void specificPhoneNumberFormat() {
        System.out.println(BLUE + "The required pattern either +7 999 123-45-67 or 8(999)123-45-67");
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN + "Enter the phone number: ");
        String input = scanner.nextLine();

        boolean verified = isFitForRegex(input);

        if (verified) {
            System.out.println(GREEN + " ✅ Success");
            return;
        }
        System.out.println(RED + " ❌ Failure");

    }

    public static void checkAllWordsStartWithCapitalLetter() {
        String fileName = "tasks/text.c5.md";
        File text = new File(fileName);

        try (Scanner reader = new Scanner(text)) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] words = line.split("\\W+");

                for (String word : words) {
                    String rgx = "^[A-Z].*$";
                    boolean isTheFirstCapitalChar = word.matches(rgx);
                    if (!isTheFirstCapitalChar) continue;
                    System.out.println(GREEN + "A word is: " + BLUE + word);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred during reading a file: " + fileName);
            e.printStackTrace();
        }


    }

    public static boolean isFitForRegex(String str) {
        String regex = "^(?:\\+7\\s\\d{3}\\s\\d{3}-\\d{2}-\\d{2}|8\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2})$";
        boolean isRegexOk = str.matches(regex);
        if (isRegexOk) return true;
        return false;
    }
}