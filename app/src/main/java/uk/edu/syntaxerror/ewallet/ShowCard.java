package uk.edu.syntaxerror.ewallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_card);

        Intent i = getIntent();
        String data = i.getStringExtra("data");

        //TODO: make it look nice. Here or in Account class

        TextView tw = (TextView) findViewById(R.id.displayData);
        tw.setText(data);
    }
}
