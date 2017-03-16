package uk.edu.syntaxerror.ewallet;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kacper on 16.03.2017.
 */

public class CustomCardAdapter extends ArrayAdapter {
    public CustomCardAdapter(@NonNull Context context, ArrayList<Account> accounts) {
        super(context, 0, accounts);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Account acc = (Account) getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main_hub_list, parent, false);
        }
        // Lookup view for data population
        TextView accName = (TextView) convertView.findViewById(R.id.accountName);
        TextView accNum = (TextView) convertView.findViewById(R.id.accountNum);
        // Populate the data into the template view using the data object
        accName.setText(acc.getAccountName());
        accNum.setText(acc.getAccountNum());
        // Return the completed view to render on screen
        return convertView;
    }
}
