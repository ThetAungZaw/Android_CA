package com.example.lenovo.team01b_androidca;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.List;

public class ListBooks extends ListActivity {

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);

        Bundle bundle = getIntent().getExtras();
        final String searchTitle = bundle.getString("Title");
        List<Book> bk = Book.searchBook(searchTitle);

        MyAdapter adapter = new MyAdapter(this, R.layout.activity_list_books, bk);
        setListAdapter(adapter);

    }

    protected void onListItemClick(ListView l, View v,
                                   int position, long id) {
        Book item = (Book) getListAdapter().getItem(position);
        Intent intent = new Intent(this, BookDetails.class);
        intent.putExtra("bid", item.get("BookId"));
        startActivity(intent);
    }

}

