package lt.esdc.stringOps;

public class StringOps {
    public static void main(String[] args) {
        new StringOps().init();
    }

    public void init() {
        determineRepeatableWords();
    }

    //    SHINES rain falls Rain falls wind gentle WIND gentle ocean blue Ocean blue Earth
    public void determineRepeatableWords() {
        String input = "Sun shines shines sun sun bright bright".toLowerCase();
        String[] arr = input.toLowerCase().split("\s+");
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            int counter = 0;

            for (int j = 0; j < arr.length; j++) {

                if (word.equals(arr[j])) {
                    counter++;
                    System.out.println("word.equals(arr[j]): " + word.equals(arr[j]));
                    System.out.println("word vs arr[j]: " + word + " -> " + arr[j]);
                }
            }
            System.out.printf("The word <%s> occured <%d> times ->\n" + word, counter);
        }

    }
}