package db.learnDB;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddActivity extends AppCompatActivity {

    EditText title , author , pages;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        title = findViewById(R.id.TiledEditText);
        author = findViewById(R.id.AuthorEditTextText);
        pages = findViewById(R.id.PageEditTextNumber);
        add = findViewById(R.id.addButton);

        add.setOnClickListener(v -> {
            DatabaseManager db = new DatabaseManager(this);
            db.addBook(title.getText().toString().trim(), author.getText().toString().trim(), Integer.parseInt(pages.getText().toString()));
        });
    }
}