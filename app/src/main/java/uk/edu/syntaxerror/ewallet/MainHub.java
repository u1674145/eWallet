package uk.edu.syntaxerror.ewallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static uk.edu.syntaxerror.ewallet.R.layout.activity_main_hub_list;

public class MainHub extends Activity {

    private ArrayList<Account> accounts = new ArrayList<Account>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);



        //TODO: add saved cards to list;

        createArrayAdapter();
        getStuffFromIntent();

    }

    private void createArrayAdapter() {

        accounts.add(new Account("Ben", "55554"));
        accounts.add(new Account("Bob", "99754"));

        CustomCardAdapter adapter = new CustomCardAdapter(this, accounts);

        ListView listView = (ListView) findViewById(R.id.cards_list);
        listView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getStuffFromIntent();
    }

    private void getStuffFromIntent() {
        Bundle stuff = getIntent().getExtras();
        if(stuff != null) {
            String name = stuff.getString("name");
            String number = stuff.getString("number");

            if(name != null || number != null) {
                accounts.add(new Account(name, number));
            }
        }
    }

    public void addCard(View view) {
        Intent intent= new Intent(this,AddCard.class);
        startActivity(intent);
        finish();
    }


    private void errorPopup(String texts) {
        Context context = getApplicationContext();
        CharSequence text = texts;

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
}
