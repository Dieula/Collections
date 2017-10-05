package dieula.collections.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import dieula.collections.R;

public class RegisterActivity extends AppCompatActivity {

    EditText edT,edT2, edT3,edT4 ;
    Button Butto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edT = (EditText) findViewById(R.id.etNomComplet);
        edT2 = (EditText) findViewById(R.id.etIdentif);
        edT3 = (EditText) findViewById(R.id.etMail);
        edT4 = (EditText) findViewById(R.id.etPass);
        Butto = (Button) findViewById(R.id.btnRegister);

    }
    public void onLogButton(View v) {
        Intent i = new Intent(RegisterActivity.this, ProfileActivity.class);
        startActivity(i);
    }
}
