package uk.edu.syntaxerror.ewallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import static uk.edu.syntaxerror.ewallet.R.layout.activity_main_hub_list;

public class MainHub extends Activity {

    private ArrayList<Account> accounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);

        accounts = new ArrayList<>();

        //TODO: add saved cards to list;

        createArrayAdapter();
        getStuffFromIntent();

    }

    private void createArrayAdapter() {
        ArrayAdapter adapter = new ArrayAdapter<Account>(this, R.layout.activity_main_hub_list, accounts);
    }

    @Override
    protected void onResume() {
        super.onResume();

        getStuffFromIntent();
    }

    private void getStuffFromIntent() {
        Bundle stuff = getIntent().getExtras();
        if(stuff != null) {
            Account acc;
            String name = stuff.getString("name");
            String number = stuff.getString("number");

            acc = new Account(name,number);
            accounts.add(acc);
            createArrayAdapter();
        }
    }

    public void addCard(View view) {
        Intent intent= new Intent(this,AddCard.class);
        startActivity(intent);
        finish();
    }
}
