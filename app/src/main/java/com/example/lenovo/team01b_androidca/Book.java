package com.example.lenovo.team01b_androidca;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Book extends HashMap<String,String> {

    final static String baseURL = "http://apitesting20180622105156.azurewebsites.net/api/";

    public Book(String BookId, String Title, String ISBN, String Author, String Stock, String Price, String Genre) {
        put("BookId", BookId);
        put("Title", Title);
        put("ISBN", ISBN);
        put("Author", Author);
        put("Stock", Stock);
        put("Price", Price);
        put("Genre", Genre);
    }

    public static List<Book> readBook(String url) {
        List<Book> book = new ArrayList<Book>();
        String name = null;
        JSONArray a = JSONParser.getJSONArrayFromUrl(url);
        try {
            for (int i = 0; i < a.length(); i++) {
                JSONObject b = a.getJSONObject(i);
                book.add(new Book(b.getString("BookId"), b.getString("Title"),
                        b.getString("ISBN"), b.getString("Author")
                        , b.getString("Stock")
                        , b.getString("Price"),
                        b.getString("Genre")));
            }

        } catch (Exception e) {

            Log.e(e.toString(), "JSONArray error");
        }
        return book;
    }

    public static List<Book> searchBook(String title) {
        return readBook(baseURL + "book/" + title);
    }

    public static Book getBook(String bid) {
        JSONObject b = JSONParser.getJSONFromUrl(baseURL + "book/id/" + bid);
        try {
            return new Book(b.getString("BookId"), b.getString("Title"),
                    b.getString("ISBN"), b.getString("Author")
                    , b.getString("Stock")
                    , b.getString("Price"),
                    b.getString("Genre"));
        } catch (Exception e) {
            Log.e("Book.getBook()", "JSONArray error");
        }
        return (null);
    }

    final static String imageURL = "http://apitesting20180622105156.azurewebsites.net/api/book/image/";

    public static Bitmap getPhoto(boolean thumbnail, String id) {
        try {
            URL url = (thumbnail ?
                    new URL(String.format(imageURL + id)) :
                    new URL(String.format(imageURL + id)));
            URLConnection conn = url.openConnection();
            InputStream ins = conn.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(ins);
            ins.close();
            return bitmap;
        } catch (Exception e) {
            Log.e("Book.getPhoto()", "Bitmap error");
            return (null);
        }
    }
}
