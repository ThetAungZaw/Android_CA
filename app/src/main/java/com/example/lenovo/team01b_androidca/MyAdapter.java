package com.example.lenovo.team01b_androidca;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Book> {

    private List<Book> books;
    int resource;

    public MyAdapter(Context context, int resource, List<Book> books) {
        super(context, resource, books);
        this.resource = resource;
        this.books= books;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(resource, null);
        Book bookobject = books.get(position);
        if (bookobject != null) {
            TextView textBoxBookId = (TextView) v.findViewById(R.id.BookId);
            textBoxBookId.setText(bookobject.get("BookId"));
            TextView textBoxBookId2 = (TextView) v.findViewById(R.id.Title);
            textBoxBookId2.setText(bookobject.get("Title"));
            ImageView image = (ImageView) v.findViewById(R.id.imageView2);
            image.setImageBitmap(Book.getPhoto(true, bookobject.get("ISBN")));
        }
        return v;
    }
}