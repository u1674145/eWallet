package uk.edu.syntaxerror.ewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
    }
    public  void registerAction(View view) {
        //TODO: register action
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}