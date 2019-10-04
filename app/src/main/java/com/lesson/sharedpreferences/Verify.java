package com.lesson.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Verify extends AppCompatActivity
{

    EditText etSchoolVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);
    }

    public void verifySchool (View v)
    {
        SharedPreferences sp = getSharedPreferences("spSchools", MODE_PRIVATE);
        String school1SP = sp.getString("school1", null);
        String school2SP = sp.getString("school2", null);
        String school3SP = sp.getString("school3", null);
        String schoolVerify = etSchoolVerify.getText().toString();
        
        if(schoolVerify.equals(school1SP) || schoolVerify.equals(school2SP) || schoolVerify.equals(school3SP))
        {
            Toast.makeText(this, schoolVerify + " is participating in the UAAP", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "Invalid School/Input", Toast.LENGTH_LONG).toString();
        }
    }
}
