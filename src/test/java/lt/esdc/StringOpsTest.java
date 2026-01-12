package lt.esdc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringOpsTest {

    // isFitForRegex_shouldReturnTrue_forValidPhoneNumSunbers
    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_1Sun() {
        // Arrange
        // Act
        String phone1 = "+7 999 123-45-67";


        // Assert
        assertTrue(StringOps.isFitForRegex(phone1));


    }

    @Test
    void isFitForRegex_shouldReturnTrue_forValidPhoneNumbers_2Sun() {
        // Arrange
        // Act
        String phone2 = "8(999)123-45-67";

        // Assert
        assertTrue(StringOps.isFitForRegex(phone2));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_withoutPlusPrefixSun() {
        // Arrange
        // Act
        String withoutPlus = "7 999 123-45-67";

        // Assert
        assertFalse(StringOps.isFitForRegex(withoutPlus));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongCountryCodeSun() {
        String wrongCountryCode = "+8 999 123-45-67";
        assertFalse(StringOps.isFitForRegex(wrongCountryCode));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceAfterPlus7Sun() {
        String missingSpace = "+7999 123-45-67";
        assertFalse(StringOps.isFitForRegex(missingSpace));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingSpaceBetweenGroupsSun() {
        String missingSpaceBetweenGroups = "+7 999123-45-67";
        assertFalse(StringOps.isFitForRegex(missingSpaceBetweenGroups));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_spacesInsteadOfHyphensSun() {
        String spacesInsteadOfHyphens = "+7 999 123 45 67";
        assertFalse(StringOps.isFitForRegex(spacesInsteadOfHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooFewDigitsInAreaCode_plus7Sun() {
        String tooFewDigits = "+7 99 123-45-67";
        assertFalse(StringOps.isFitForRegex(tooFewDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_tooManyDigitsInAreaCode_plus7Sun() {
        String tooManyDigits = "+7 9999 123-45-67";
        assertFalse(StringOps.isFitForRegex(tooManyDigits));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingParentheses_in8FormatSun() {
        String missingParentheses = "8 999 123-45-67";
        assertFalse(StringOps.isFitForRegex(missingParentheses));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingClosingParenthesis_in8FormatSun() {
        String missingClosingParen = "8(999123-45-67";
        assertFalse(StringOps.isFitForRegex(missingClosingParen));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_missingHyphens_in8FormatSun() {
        String missingHyphens = "8(999)1234567";
        assertFalse(StringOps.isFitForRegex(missingHyphens));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_wrongSeparatorAfterParentheses_in8FormatSun() {
        String wrongSeparator = "8(999) 123-45-67"; // space not allowed by your regex
        assertFalse(StringOps.isFitForRegex(wrongSeparator));
    }

    @Test
    void isFitForRegex_shouldReturnFalse_forInvalidPhoneNumber_containsLettersSun() {
        String containsLetters = "+7 999 12a-45-67";
        assertFalse(StringOps.isFitForRegex(containsLetters));
    }

    // findEvenRepeatableWords
    @Test
    void findEvenRepeatableWords_ifInputNull() {
        // Arrange
        String input = null;
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_ifInputIsBlank() {
        // Arrange
        String input = "";
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        // Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_ifOneWordIsSubstringOfAnother() {
        // Arrange
        String input = "he the the";
        String expected = "he";
        // Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void findEvenRepeatableWords_shouldReturnBrightSun() {
        //Arrange
        String expected = "bright";
        String input = "Sun sun brIght bright bRigHt shines shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findEvenRepeatableWords_containsOddRepetitionsReturnNull() {
        //Arrange
        String expected = null;
        String input = "Sun sun bright bright shines shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertNull(actual);
    }

    @Test
    void findEvenRepeatableWords_containsDifferentSeparators_shouldReturnSunSun() {
        //Arrange
        String expected = "sun";
        String input = "Sun ) sun sUn ( bright ; bright - shines , shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findEvenRepeatableWords_separatorsInTheBeginningOfAline_shouldReturnSun() {
        //Arrange
        String expected = "sun";
        String input = "( ) ) ( Sun ) sun sUn ( bright ; bright - shines , shines";
        //Act
        String actual = StringOps.findEvenRepeatableWords(input);
        //Assert
        Assertions.assertEquals(expected, actual);
    }

    // upperFirstLetterOfEachSentence
    @Test
    void upperFirstLetterOfEachSentence_ifInputIsNull() {
        //Arrange
        String input = null;
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ifInputIsBlank() {
        //Arrange
        String input = "";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsAnyCharactersExceptAlphabetic() {
        //Arrange
        String input = ". !@#$()-";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsAnyCharactersExceptAlphabeticButWithDotInTheMiddle() {
        //Arrange
        String input = ". !@#.$()-";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_OnlyWhiteSpaces() {
        //Arrange
        String input = "          ";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertNull(actual);
    }


    @Test
    void upperFirstLetterOfEachSentence_ContainsSeparatorsAtTheBeginning() {
        //Arrange
        String input = ".  the sun shines. brightly over the city. houses and people.";
        String expected = "The sun shines. Brightly over the city. Houses and people.";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void upperFirstLetterOfEachSentence_ContainsCommas() {
        //Arrange
        String input = ".  the sun, shines. brightly, over the city. houses and, people.";
        String expected = "The sun, shines. Brightly, over the city. Houses and, people.";
        //Act
        String actual = StringOps.upperFirstLetterOfEachSentence(input);
        //Assert
        assertEquals(expected, actual);
    }

}