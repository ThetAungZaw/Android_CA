package com.example.lenovo.team01b_androidca;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class BookDetails extends Activity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        Intent i = getIntent();
        String bid = i.getStringExtra("bid");
        Book bk = (Book) Book.getBook(bid);
        show(bk);
    }

    void show(Book bk) {
        int []ids = {R.id.editText1, R.id.editText2, R.id.editText3, R.id.editText4,R.id.editText5 ,R.id.editText6 ,R.id.editText7};
        String []keys = {"BookId", "Title","Author", "Price","Stock", "ISBN","Genre"};
        for (int i=0; i<keys.length; i++) {
            EditText e = (EditText) findViewById(ids[i]);
            e.setText(bk.get(keys[i]));
        }
        ImageView image = (ImageView) findViewById(R.id.imageView);
        image.setImageBitmap(Book.getPhoto(false, bk.get("ISBN")));


    }



}

