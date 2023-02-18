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
        int count =0; int count1 =0;  int count2 =0;int count3 =0;
   if(oldPassword == this.password){

       if(newPassword.length()>=8){
           //uppercase

           for(int i=0;i<newPassword.length();i++){

               if(newPassword.charAt(i)>=65 && newPassword.charAt(i)<=90){
                   count++;
               }

           //lowercase
              else if(newPassword.charAt(i)>=90 && newPassword.charAt(i)<=122){
                   count1++;
               }
//digit
           else if(Character.isDigit(newPassword.charAt(i))){
                   count2++;
               }
               else {
                   count3++;
               }
           }      }
   }
        if(count >0||count1 >0||count2>0||count3>0){
            this.password = newPassword;
            System.out.println("Password changed Successfully");
        }
    }
}
