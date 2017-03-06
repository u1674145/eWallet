package uk.edu.syntaxerror.ewallet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginAction(View view) {
        TextView email_text = (TextView) findViewById(R.id.login_email);
        TextView password_text = (TextView) findViewById(R.id.login_password);

        LoginAction login = new LoginAction(email_text.getText().toString(), password_text.getText().toString());

        if(login.isValidEmail() && login.isValidPassword()) {
            Intent intent = new Intent(this, MainHub.class);
            intent.putExtra("login", true);
            startActivity(intent);
        }else {
            ErrorPopup();
        }
    }

    private void ErrorPopup() {
        //TODO: need some tweaks and fixs

        layoutInflater.getContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_layout);


        ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popupmsg,null);

        popupWindow = new PopupWindow(container, 400, 400, true);
        popupWindow.showAtLocation(relativeLayout, Gravity.NO_GRAVITY, 500, 500);

        container.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public  void registerAction(View view) {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
