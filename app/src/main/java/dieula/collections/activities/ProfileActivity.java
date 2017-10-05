package dieula.collections.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dieula.collections.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
    public void LogIn(View v){
        Intent i = new Intent(ProfileActivity.this, CollectionsActivity.class);
        startActivity(i);
    }
}
