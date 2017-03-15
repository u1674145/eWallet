package uk.edu.syntaxerror.ewallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View view) {
        TextView email_text = (TextView) findViewById(R.id.login_email);
        TextView password_text = (TextView) findViewById(R.id.login_password);

        LoginAction login = null;
        if (email_text != null && password_text != null) {
            login = new LoginAction(email_text.getText().toString(), password_text.getText().toString());
        }

        if (login != null) {
            if(login.isValidEmail() && login.isValidPassword()) {
                Intent intent = new Intent(this, MainHub.class);
                intent.putExtra("login", email_text.getText().toString());
                startActivity(intent);
            }else {
                ErrorPopup();
            }
        }
    }

    private void ErrorPopup() {
        Context context = getApplicationContext();
        CharSequence text = "Invalid Mail or password!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }

    public  void registerAction(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
