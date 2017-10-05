package dieula.collections.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dieula.collections.R;

public class UserLoginActivity extends AppCompatActivity {

    Button but;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        but = (Button) findViewById(R.id.btnLogin);
        text = (TextView) findViewById(R.id.tvRegister);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserLoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }
    public void LogIn(View v){
        Intent i = new Intent(UserLoginActivity.this, CollectionsActivity.class);
        startActivity(i);
    }
}
