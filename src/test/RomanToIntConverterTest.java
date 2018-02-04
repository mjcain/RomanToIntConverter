package test;

import com.roman.RomanToIntConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RomanToIntConverterTest {

    @Test
    public void assertValidSingleCharIConvertsToInt() {
        assertRomanEqualsInt("I", 1);
    }

    @Test
    public void assertValidSingleCharVConvertsToInt() {
        assertRomanEqualsInt("V", 5);
    }

    @Test
    public void assertLargerFollowedBySmallerCharConvertsToInt() {
        assertRomanEqualsInt("VI", 6);
    }

    @Test
    public void assertSmallerFollowedByLargerCharConvertsToInt() {
        assertRomanEqualsInt("IV", 4);
    }

    @Test
    public void assertMaximumRomanNumeralConvertsToInt() {
        assertRomanEqualsInt("MMMCMXCIX", 3999);
    }

    @Test
    public void assertInvalidInputThrowsIllegalArgumentException() { assertIllegalArgument("BOB"); }

    @Test
    public void assertValidMixedWithInvalidCharsThrowsIllegalArgumentException() { assertIllegalArgument("VIBOB"); }

    @Test()
    public void assertEmptyInputThrowsIllegalArgumentException() { assertIllegalArgument(""); }

    @Test()
    public void assertNullInputThrowsIllegalArgumentException() { assertIllegalArgument(null); }

    @Test
    public void assertIntegerTooLargeForNumeralRepresentationThrowsIllegalArgumentException() { assertIllegalArgument("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM"); }

    private void assertRomanEqualsInt(String input, int expectedOutput)
    {
        assertEquals(expectedOutput, RomanToIntConverter.convert(input));
    }

    private void assertIllegalArgument(String input)
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> RomanToIntConverter.convert(input), "Input provided is not valid. Please try again.");
    }
}