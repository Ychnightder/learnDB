package db.learnDB;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    private Context context;
    private ArrayList<String> books_id , books_title , books_author , books_pages;

    public CustomAdapter(Context context, ArrayList<String> books_id, ArrayList<String> books_title, ArrayList<String> books_author, ArrayList<String> books_pages) {
        this.context = context;
        this.books_id = books_id;
        this.books_title = books_title;
        this.books_author = books_author;
        this.books_pages = books_pages;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater infalter = LayoutInflater.from(context);
        View view = infalter.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
            holder.book_id_text.setText(books_id.get(position));
            holder.book_title_text.setText(books_title.get(position));
            holder.book_author_text.setText(books_author.get(position));
            holder.book_pages_text.setText(books_pages.get(position));
    }

    @Override
    public int getItemCount() {
        return books_id.size();
    }

    public static class MyViewHolder  extends RecyclerView.ViewHolder{

        TextView book_id_text , book_title_text , book_author_text , book_pages_text;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            book_author_text = itemView.findViewById(R.id.book_author_text);
            book_id_text = itemView.findViewById(R.id.book_id_text);
            book_pages_text = itemView.findViewById(R.id.book_pages_text);
            book_title_text = itemView.findViewById(R.id.book_title_text);
        }
    }
}
