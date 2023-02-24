package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        int isCapital =0; int isLowerCase =0;  int isdigit =0;int isSpecialChar =0;
   if(oldPassword == this.password){

       if(newPassword.length()>=8){
           //uppercase

           for(int i=0;i<newPassword.length();i++){
              char ch = newPassword.charAt(i);
               if(ch >=65 && ch<=90){
                   isCapital++;
               }

           //lowercase
              else if(ch >=90 && ch <=122){
                   isLowerCase++;
               }
//digit
           else if(Character.isDigit(ch)){
                   isdigit++;
               }
               else {
                   isSpecialChar++;
               }
           }      }
       else{
           System.out.println("Please enter correct Password.");
       }

        if(isCapital >0||isLowerCase >0||isdigit>0||isSpecialChar>0){
            this.password = newPassword;
            System.out.println("Password changed Successfully.");
        }
   }
   else{
       System.out.println("Password doesn't matching.Please enter correct Password.");
   }
    }
}
