package db.learnDB;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerView;
        ImageButton ImageButton;

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

    }
}