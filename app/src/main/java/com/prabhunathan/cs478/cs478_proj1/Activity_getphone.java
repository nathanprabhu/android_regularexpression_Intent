package com.prabhunathan.cs478.cs478_proj1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.*;


public class Activity_getphone extends AppCompatActivity {
    private Button button1;
    //private EditText txtDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_getphone);
        setTitle("Identify Phone number");

        button1 = (Button) findViewById(R.id.button3    );
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText txtDesc=(EditText)findViewById(R.id.editText);
                String mydata = txtDesc.getText().toString();
                String aphone="";

                String re1="(\\()";
                String re2="(\\d{3})";
                String re3="(\\))";
                String re4="(\\s+)";

                String re6="(\\d{3})";
                String re7="(\\-)";
                String re8="(\\d{4})";

                Pattern p = Pattern.compile(re1+re2+re3+re4+re6+re7+re8,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

                Matcher m = p.matcher(mydata);
                if (m.find())
                {
                    String c1=m.group(1);
                    String c2=m.group(2);
                    String c3=m.group(3);
                    String c4=m.group(4);
                    String c5=m.group(5);
                    String c6=m.group(6);
                    String c7=m.group(7);
                    aphone=c2.toString()+c5.toString()+c7.toString();
                }

                Pattern q = Pattern.compile(re1+re2+re3+re6+re7+re8,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

                Matcher n = q.matcher(mydata);
                if (n.find())
                {
                    String c11=n.group(1);
                    String c12=n.group(2);
                    String c13=n.group(3);
                    String c14=n.group(4);
                    String c15=n.group(5);
                    String c16=n.group(6);
                    aphone=c12.toString()+c14.toString()+c16.toString();
                }
                System.out.print(aphone+"\n");
                if(aphone==""){
                    Toast.makeText(getApplicationContext(),
                            "No Phone number found", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+aphone));
                    startActivity(intent);
                }
            }
        });

    }
}
