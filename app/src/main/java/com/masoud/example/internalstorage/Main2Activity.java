package com.masoud.example.internalstorage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
EditText userEdittext,passEdittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        userEdittext=(EditText) findViewById(R.id.edittextuser);
        passEdittext=(EditText) findViewById(R.id.edittextPass);

    }
public  void save(View view){
    FileInputStream fis=null;
    try {
        fis=openFileInput("mydata.txt");
        int read=-1;
        StringBuffer buffer=new StringBuffer();
        while((read=fis.read())!=-1){
           buffer.append((char) read);
        }

        Log.d("Masoud",buffer.toString());
        String text1=buffer.substring(0,buffer.indexOf(" "));
        String text2=buffer.substring(buffer.indexOf(" ")+1);

        userEdittext.setText(text1);
        passEdittext.setText(text2);

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
finally {
        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
    public void back(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
