package uk.edu.syntaxerror.ewallet;

/**
 * Created by U1674145 on 27/02/2017.
 *  Login control class.
 */
public class LoginAction{

    private boolean validEmail;
    private boolean validPassword;

    /**     * Constructor for objects of class Login     */
    public LoginAction(String imputEmail , String imputPassword) {
        checkEmail(imputEmail);
        checkPassword(imputPassword);
        }


    public boolean isValidEmail() {
        return validEmail;
    }

    public boolean isValidPassword() {
        return validPassword;
    }

    private boolean checkEmail(String imputEmail)    {
        //(""+"@"+""+"."+"") does not work can only check for 1 symbol
        validEmail = imputEmail.contains("" + "@" + "") && imputEmail.contains(".");
        return validEmail;
    }

    private boolean checkPassword(String imputPassword){
        // check for upper case and lover case characters.
        validPassword = !imputPassword.equals(imputPassword.toLowerCase()) && !imputPassword.equals(imputPassword.toUpperCase());
        return validPassword;
    }

}