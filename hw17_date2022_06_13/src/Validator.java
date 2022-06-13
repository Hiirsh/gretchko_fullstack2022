public class Validator {

    public static boolean isCreditCardNumber(String cardNumber) {
        return cardNumber.matches("(\\d{8,16})");
    }

    public static boolean isDateFormatDDMMYYYY(String data) {
        return data.matches("([0-2][0-9]|3[0-1])\\.(0[0-9]|1[0-2])\\.([0-2][0-9][0-9][0-9])");
    }

    public static boolean isDateFormatYYYYMMDD(String data) {
        return data.matches("([0-2]?[0-9]?[0-9]?[0-9])\\-(0[0-9]|1[0-2])\\-([0-2][0-9]|3[0-1])");
    }

    public static boolean isPhoneNumberCorrect(String phone) {
        return phone.matches("\\+(\\d{2})(\\(\\d{2}\\))(\\d{4})\\-(\\d{4})");
    }

    public static boolean isLessOrEqual255(String num) {
        return num.matches("\\d|1?\\d{2}|(2([0-4]\\d|5[0-5]))");
    }
}

// a) Credit card number (8-16 digits)
// b) Date (Format: DD.MM.YYYY)
// c) Date (Format: YYYY-MM-DD)
// d) Phone Number (Format: +99(99)9999-9999)
// e) Number less and equals 255
// (\\d{2})(\\(\\d{2}\\))(\\d{4})\\-(\\d{4})