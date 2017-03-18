package uk.edu.syntaxerror.ewallet;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm = getSupportFragmentManager();
    FragmentTransaction transaction = fm.beginTransaction();
    Fragment myListFragment = new MyListFragment();
    Fragment addCardFragment = new AddCardFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void addCard(View view) {
        errorPopup("addCard");

        transaction.replace(R.id.contentFragment, addCardFragment);
        transaction.commit();
    }

    public void addNewCard(View view) {
        errorPopup("addNewCard");

        transaction.replace(R.id.contentFragment, myListFragment);
        transaction.commit();
    }


    private void errorPopup(CharSequence text) {
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

}
