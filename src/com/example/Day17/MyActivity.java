package com.example.Day17;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    private EditText editText;
    private Button send;
    private Button second;
    private static final String TEMP_SMS = "temp_sms";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        init();
        SharedPreferences sharedPreferences = getSharedPreferences(TEMP_SMS,MODE_WORLD_READABLE);
        String content = sharedPreferences.getString("sms content","");
        editText.setText(content);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }

    private void init() {

        editText = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.send);
        second = (Button) findViewById(R.id.second);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences(TEMP_SMS,MODE_WORLD_WRITEABLE).edit();
        editor.putString("sms content",editText.getText().toString());
        editor.commit();
    }
}
