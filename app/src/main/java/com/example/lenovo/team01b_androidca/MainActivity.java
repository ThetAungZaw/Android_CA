package com.example.lenovo.team01b_androidca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle i=getIntent().getExtras();
        if(i!=null){
            Toast.makeText(this,i.getString("error"),Toast.LENGTH_LONG).show();
        }
        Button button =(Button) findViewById(R.id.button1);
        final EditText editText=(EditText)findViewById(R.id.editText1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchTitle= editText.getText().toString();

                Intent intent=new Intent(getApplicationContext(),ListBooks.class);
                intent.putExtra("Title",searchTitle);
                startActivity(intent);
            }
        });
    }
}
