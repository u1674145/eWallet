package uk.edu.syntaxerror.ewallet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
    }

    public void addNewCard(View view) {
        TextView name = (TextView) findViewById(R.id.accName);
        TextView number = (TextView) findViewById(R.id.accNum);

        Intent intent = new Intent(this, MainHub.class);


        if(name.getText().toString().equals("") || number.getText().toString().equals("")) {
            errorPopup("Name or number is empty.");
            return;
        }

        progresBar();

        if(number.length()< 15 || number.length() > 16) {
            errorPopup("Card number seems uncomplete.");
            return;
        }
            intent.putExtra("name", name.getText().toString());
            intent.putExtra("number", number.getText().toString());
            startActivity(intent);
    }

    private void progresBar() {
        final ProgressDialog dialog = ProgressDialog.show(this,"Connecting bank...","Collecting data.");
        dialog.show();

        Handler h = new Handler();
        h.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }
        ,3000); //wait for it.
    }

    private void errorPopup(String texts) {
        Toast toast = Toast.makeText(getApplicationContext(), texts, Toast.LENGTH_SHORT);
        toast.show();
    }


}
