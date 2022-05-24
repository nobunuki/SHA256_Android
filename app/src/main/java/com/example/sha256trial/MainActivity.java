package com.example.sha256trial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void SHA(View view) {
        EditText edtinput = (EditText) findViewById(R.id.input);
        TextView hasiltxt = (TextView) findViewById(R.id.HasilTextView);

        byte[] inputData = edtinput.getText().toString().getBytes();
        byte[] outputData = new byte[0];
        try {
            outputData = SHA.encryptSHA(inputData, "SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
        }
        BigInteger shaData = new BigInteger(1, outputData);
        hasiltxt.setText(shaData.toString(16));


    }

    public void BASE64(View view) {

        EditText edtinput = (EditText) findViewById(R.id.input);
        TextView txtoutput = (TextView) findViewById(R.id.HasilTextView);

        byte[] base64data = edtinput.getText().toString().getBytes();
        String base64str = "";

        try {
            base64str = base64.encryptBASE64(base64data);
        } catch (Exception e) {
            e.printStackTrace();
        }
       txtoutput.setText(base64str);
    }
}