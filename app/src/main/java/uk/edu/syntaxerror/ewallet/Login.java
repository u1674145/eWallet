package uk.edu.syntaxerror.ewallet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View view) {
        //TODO: login action
    }
    public  void registerAction(View view) {
        //TODO: register action
        setContentView(R.layout.activity_list_item);
    }
}
