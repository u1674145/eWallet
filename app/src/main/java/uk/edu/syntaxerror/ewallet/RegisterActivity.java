package uk.edu.syntaxerror.ewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView name, nextname, pass, nextpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (TextView) findViewById(R.id.register_email);
        nextname = (TextView) findViewById(R.id.register_email2);
        pass = (TextView) findViewById(R.id.register_password);
        nextpass = (TextView) findViewById(R.id.register_password2);
    }

    public void register(View view) {
        if(name.getText().toString().equals("")
                || pass.getText().toString().equals("")
                || nextname.getText().toString().equals("")
                || nextpass.getText().toString().equals("")) {
            errorPopup("Name or password is empty.");
            return;
        }
        if (!name.getText().toString().equals(nextname.getText().toString())) {
            errorPopup("names not match.");
            return;
        }

        if (!pass.getText().toString().equals(nextpass.getText().toString())) {
            errorPopup("Passwords not match.");
            return;
        }
        errorPopup("Registed.");
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }

    private void errorPopup(String texts) {
        Toast toast = Toast.makeText(getApplicationContext(), texts, Toast.LENGTH_SHORT);
        toast.show();
    }
}
