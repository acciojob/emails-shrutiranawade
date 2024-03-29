package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId) {
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword) {
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character

        if (oldPassword == password) {

            if (isValidPassword(newPassword)) {

                System.out.println("Password changed Successfully.");
                this.password= newPassword;
            } else {
                System.out.println("Short length password.");
            }
        }
        else {
            System.out.println("Password doesn't matching.Please enter correct Password.");
        }
    }



    public boolean isValidPassword(String password) {
        boolean isCapital = false;
        boolean isLowerCase = false;
        boolean isdigit = false;
        boolean isSpecialChar = false;

        if (password.length()< 8) {
            return false;
        }

            for (int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);
                if (ch >= 65 && ch <= 90) {
                    isCapital = true;
                }
                else if (ch >= 'a' && ch <= 'z') {
                    isLowerCase = true;
                }
                else if (Character.isDigit(ch)) {
                    isdigit = true;
                }
                else {
                    isSpecialChar = true;
                }
            }
        if (isCapital && isLowerCase && isdigit && isSpecialChar) {
            return true;
            }
        else return false;
            }
}
