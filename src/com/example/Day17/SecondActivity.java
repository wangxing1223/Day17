package com.example.Day17;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.*;

/**
 * Created by Administrator on 13-8-10.
 */
public class SecondActivity extends Activity {

    private Button save;
    private Button open;
    private EditText editText1;
    private EditText editText2;
    private String FILE_NAME = "file_name";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        init();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = editText1.getText().toString();
                writeChar(content);
            }
        });

        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText2.setText(readChar());
            }
        });


    }

    private String readChar() {
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            InputStreamReader fisb = new InputStreamReader(fis);
            char[]buffer = new char[fis.available()];
            fisb.read(buffer);
            fisb.close();
            return new String (buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }

    private void writeChar(String content) {

        try {
            FileOutputStream fos = openFileOutput(FILE_NAME,MODE_APPEND);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.write(content.toCharArray());
            osw.close();
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }


    private String readByte(){
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[]buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            return new String (buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private void writeByte(String content){
        try {
            FileOutputStream fos = openFileOutput(FILE_NAME,MODE_APPEND);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private void init() {

        save = (Button) findViewById(R.id.save);
        open = (Button) findViewById(R.id.open);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);

    }
}