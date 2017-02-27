package uk.edu.syntaxerror.ewallet;

/**
 * Created by U1674145 on 27/02/2017.
 */
public class LoginAction{

    private String iEmail;
    private String iPassword;
    private boolean validEmail;
    private boolean validPassword;

    /**     * Constructor for objects of class Login     */
    public LoginAction(String imputEmail , String imputPassword) {
        if (checkEmail(imputEmail)){
            if (checkPassword(imputPassword)) {
                iPassword = imputPassword;
                iEmail = imputEmail;
            }
        }else{
            iEmail= "invalid Email";
            iPassword= "invalid Password";
        }
    }
    private boolean checkEmail(String imputEmail)    {
        //(""+"@"+""+"."+"") does not work can only check for 1 symbol
        if (imputEmail.contains(""+"@"+"")){
            if(imputEmail.contains(".")){
                validEmail= true;
            }
        }else{
            validEmail= false;
        }
        return validEmail;
    }

    private boolean checkPassword(String imputPassword){
        boolean hasUppercase = !imputPassword.equals(imputPassword.toLowerCase());
        boolean hasLowercase = !imputPassword.equals(imputPassword.toUpperCase());

        if(hasUppercase && hasLowercase) {
            validPassword= true;
        }else{
            validPassword= false;
        }
        return validPassword;
    }

    public boolean isValidEmail() {
        return validEmail;
    }

    public boolean isValidPassword() {
        return validPassword;
    }

}