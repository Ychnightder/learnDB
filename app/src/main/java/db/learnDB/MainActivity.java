package db.learnDB;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        ImageButton ImageButton;

        DatabaseManager db ;
        ArrayList<String> books_id , books_title , books_author , books_pages;


    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RecyclerView);
        ImageButton = findViewById(R.id.addBtn);

        ImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddActivity.class);
            startActivity(intent);
        });

        db = new DatabaseManager(this);
        books_id = new ArrayList<>();
        books_title = new ArrayList<>();
        books_author = new ArrayList<>();
        books_pages = new ArrayList<>();
        storageDataInArray();


        adapter = new CustomAdapter(this, books_id, books_title, books_author, books_pages);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void storageDataInArray(){
        Cursor cursor = db.getBooks();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "no data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                books_id.add(cursor.getString(0));
                books_title.add(cursor.getString(1));
                books_author.add(cursor.getString(2));
                books_pages.add(cursor.getString(3));
            }

        }
    }


}