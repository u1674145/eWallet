package uk.edu.syntaxerror.ewallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    //some random useleess stuff. for now.
    // public final static String LOGIN_DATA = "uk.edu.syntaxerror.ewallet.LOGIN_DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View view) {
        //TODO: login action to take place
        TextView email_text = (TextView) findViewById(R.id.login_email);
        TextView password_text = (TextView) findViewById(R.id.login_password);

        LoginAction login = new LoginAction(email_text.getText().toString(), password_text.getText().toString());
        if(!login.isValidEmail()) {
            //TODO: ERRROR msg - not valid Email
        }else if (!login.isValidPassword()) {
            //TODO: ERROR msg - not valid password
        }else {
            Intent intent = new Intent(this, MainHub.class);
            intent.putExtra("login", true);
            startActivity(intent);
        }
    }

    public  void registerAction(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
