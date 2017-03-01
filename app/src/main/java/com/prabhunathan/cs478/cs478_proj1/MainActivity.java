package com.prabhunathan.cs478.cs478_proj1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Activity_getphone.class);
                startActivity(intent1);
            }

        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://developer.android.com/index.html");
                Intent intent3 = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent3);
                //The below intent opens the webpage in a webview.
                //Intent intent2 = new Intent(getApplicationContext(), Activity_webhelp.class);
                //startActivity(intent2);
            }

        });
    }
}
