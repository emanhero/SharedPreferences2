package com.lesson.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etSchool1, etSchool2, etSchool3;
    SharedPreferences sp;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSchool1 = findViewById(R.id.school1);
        etSchool2 = findViewById(R.id.school2);
        etSchool3 = findViewById(R.id.school3);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View view)
           {
               openActivity2();

           }
        });
    }
    public void openActivity2()
    {
        Intent intent = new Intent(this, Verify.class);
        startActivity(intent);
    }

    public void saveData(View v)
    {
        sp = getSharedPreferences("spSchools", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        String school1 = etSchool1.getText().toString();
        String school2 = etSchool2.getText().toString();
        String school3 = etSchool3.getText().toString();
        editor.putString("school1", school1);
        editor.putString("school2", school2);
        editor.putString("school3", school3);
        editor.commit();
        Toast.makeText(this, "School Submitted", Toast.LENGTH_LONG).show();
    }
}
