package uk.edu.syntaxerror.ewallet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
    }

    public void addCard(View view) {
        TextView name = (TextView) findViewById(R.id.accName);
        TextView number = (TextView) findViewById(R.id.accNum);

        String get_name, get_number;

        if (name != null || number != null) {

            get_name = name.getText().toString();
            get_number = number.getText().toString();

            if(get_name != null || get_number != null) {
                Intent intent = new Intent(this, MainHub.class);
                intent.putExtra("name", get_name);
                intent.putExtra("number", get_number);
                startActivity(intent);
                finish();
            } else {
                errorPopup();
            }
        } else {
            errorPopup();
        }
    }

    private void errorPopup() {
        Context context = getApplicationContext();
        CharSequence text = "Invalid/empty name or number!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }


}
