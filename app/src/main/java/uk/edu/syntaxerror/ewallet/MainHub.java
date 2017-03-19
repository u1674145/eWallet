package uk.edu.syntaxerror.ewallet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainHub extends Activity {

    private ArrayList<Account> accounts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_hub);

        try {
            readArrayFromFile();
            readIntent();
            createArrayAdapter();
        } catch (Exception e) {
            e.printStackTrace();
        //    errorPopup("onCreate exception.");
        }

    }

    private void readIntent() {
        try {
            Intent i = getIntent();

            String get_name = i.getStringExtra("name");
            String get_number = i.getStringExtra("number");

            if(get_name.equals("") || get_number.equals("")) {
                errorPopup("name or number are empty.");
                return;
            }

           accounts.add(new Account(get_name,get_number));
           writeArrayToFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createArrayAdapter() {

        final CustomCardAdapter adapter = new CustomCardAdapter(this, accounts);

        ListView listView = (ListView) findViewById(R.id.cards_list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                writeArrayToFile();
                Intent intent= new Intent(MainHub.this, ShowCard.class);
                intent.putExtra("data", adapter.getItem(position).toString());
                startActivity(intent);

            }
        });

    }

    public void addCard(View view) {
        writeArrayToFile();
        Intent intent= new Intent(this,AddCard.class);
        startActivity(intent);
    }

    private void errorPopup(String texts) {
        Toast toast = Toast.makeText(getApplicationContext(), texts, Toast.LENGTH_SHORT);
        toast.show();
    }

    private void readArrayFromFile () {

        FileInputStream inputStream;

        try {
            inputStream = openFileInput("acc.data");
            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                String [] arrayline = line.split("=",2);
                accounts.add(new Account(arrayline[0],arrayline[1]));
            }

            inputStream.close();
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
            errorPopup("cant read data.");
        }

    }
    private void writeArrayToFile () {
        String string = "\n";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput("acc.data", Context.MODE_PRIVATE);
            outputStream.flush();
            for (Account a:accounts) {
                outputStream.write((a.getAccountName()+"=").getBytes());
                outputStream.write((a.getAccountNum()).getBytes());
                outputStream.write(string.getBytes());
            }
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            errorPopup("error saving.");
        }
    }
}

