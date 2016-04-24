package com.masoud.example.internalstorage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    File file=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.editText1);
        password = (EditText) findViewById(R.id.editText2);


    }

    public void next(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void save(View view) {
        String text1 = username.getText().toString();
        String text2 = password.getText().toString();
text1=text1+" ";
        FileOutputStream fos= null;
        try {
            file=getFilesDir();
            fos = openFileOutput("mydata.txt", Context.MODE_PRIVATE);
            fos.write(text1.getBytes());
            fos.write(text2.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("mymassage",e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Toast.makeText(this, "data saved"+file+ "/mydata.txt", Toast.LENGTH_SHORT).show();

    }

}
