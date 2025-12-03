package lt.esdc.stringOps;

import com.github.javafaker.Faker;

public class StringOps {
    public static void main(String[] args) {
    new StringOps().init();
    }

     public void init() {
        randomSentences(10, " | ");
    }
    public String randomSentences(int quantity, String delimiter) {
        Faker faker = new Faker();
        return faker.name().fullName();

    }
}