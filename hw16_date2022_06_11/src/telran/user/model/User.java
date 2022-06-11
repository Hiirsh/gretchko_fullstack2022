package telran.user.model;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        setEmail(email);
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)) {
            this.email = email;
        } else {
            System.out.println(email + " is not valid");
        }

    }

    /*
     * 1) @ exists and only one (done)
     * 2) dot after @ (done)
     * 3) after last dot minimum 2 symbols (done)
     * 4) alphabetic, digits, _ , -, ., @ (done)
     */
    private boolean validateEmail(String email) {
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || email.indexOf('@', indexAt + 1) >= 0) {
            return false;
        }
        if (email.indexOf('.', indexAt + 1) < 0) {
            return false;
        }
        if (email.lastIndexOf('.') >= email.length() - 2) {
            return false;
        }
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            if (!(Character.isAlphabetic(c) || Character.isDigit(c) || c == '_' || c == '-' || c == '.' || c == '@')) {
                return false;
            }
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (validatePassword(password)) {
            this.password = password;
        } else {
            System.err.println("Password " + password + " is not valid");
        }
    }

    /*
     * 1) minimum 8 symbols
     * 2) min one symbol of uppercase
     * 3) min one symbol of lowercase
     * 4) min one digit
     * 5) min one special symbol (!%@*&)
     */
    private boolean validatePassword(String password) {
        boolean resUpCase = false;
        boolean resLowCase = false;
        boolean resDig = false;
        boolean resSpec = false;
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if (!resUpCase && Character.isUpperCase(c)) {
                    resUpCase = true;
                }
                if (!resLowCase && Character.isLowerCase(c)) {
                    resLowCase = true;
                }

                if (!resDig && Character.isDigit(c)) {
                    resDig = true;
                }
                if (!resSpec && c >= 33 && c <= 47) {// как тут прописать через Character не нашел
                    resSpec = true;
                }
                // if (!resUpCase && c >= 65 && c <= 90) {
                // resUpCase = true;
                // }
                // if (!resLowCase && c >= 97 && c <= 122) {
                // resLowCase = true;
                // }

                // if (!resDig && c >= 48 && c <= 57) {
                // resDig = true;
                // }
                // if (!resSpec && c >= 33 && c <= 47) {
                // resSpec = true;
                // }
            }
        }
        return resDig && resSpec && resUpCase && resLowCase;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", password=" + password + "]";
    }
}
