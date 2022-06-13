import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidationTest {

    @Test
    public void testCreditCard() {
        assertTrue(Validator.isCreditCardNumber("12345678"));
        assertTrue(Validator.isCreditCardNumber("12345678012345"));
        assertTrue(Validator.isCreditCardNumber("123456786544"));
        assertFalse(Validator.isCreditCardNumber("123456"));

    }

    @Test
    public void testDateFormatDDMMYYY() {
        assertTrue(Validator.isDateFormatDDMMYYYY("10.12.1994"));
        assertTrue(Validator.isDateFormatDDMMYYYY("01.02.1194"));
        assertTrue(Validator.isDateFormatDDMMYYYY("31.12.0004"));
        assertFalse(Validator.isDateFormatDDMMYYYY("33.13.4"));
    }

    @Test
    public void testDateFormatYYYYMMDD() {
        assertTrue(Validator.isDateFormatYYYYMMDD("2022-06-13"));
        assertTrue(Validator.isDateFormatYYYYMMDD("1994-12-31"));
        assertTrue(Validator.isDateFormatYYYYMMDD("1000-01-01"));
    }

    @Test
    public void testPhoneNumber() {
        assertTrue(Validator.isPhoneNumberCorrect("+99(99)9999-9999"));
        assertTrue(Validator.isPhoneNumberCorrect("+92(31)1234-5678"));
        assertFalse(Validator.isPhoneNumberCorrect("(31)1234-5678"));
    }

    @Test
    public void testLessOrEqual255() {
        assertTrue(Validator.isLessOrEqual255("255"));
        assertTrue(Validator.isLessOrEqual255("199"));
        assertTrue(Validator.isLessOrEqual255("10"));
        assertTrue(Validator.isLessOrEqual255("9"));
        assertFalse(Validator.isLessOrEqual255("256"));
    }
}
// a) Credit card number (8-16 digits)
// b) Date (Format: DD.MM.YYYY)
// c) Date (Format: YYYY-MM-DD)
// d) Phone Number (Format: +99(99)9999-9999)
// e) Number less and equals 255