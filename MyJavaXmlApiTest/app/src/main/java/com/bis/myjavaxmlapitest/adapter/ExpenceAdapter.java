package com.bis.myjavaxmlapitest.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bis.myjavaxmlapitest.data.model.xmlModel.author.Book;
import com.bis.myjavaxmlapitest.databinding.ExpenceListBinding;

import java.util.List;

public class ExpenceAdapter extends RecyclerView.Adapter<ExpenceAdapter.ViewHolder> {
    private List<Book> bookList;

    public ExpenceAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ExpenceListBinding listItem = ExpenceListBinding.inflate(inflater, parent, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book item = bookList.get(position);
        holder.bind(item, position, getItemCount());
    }

    @Override
    public int getItemCount() {
        return bookList != null ? bookList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ExpenceListBinding binding;

        public ViewHolder(@NonNull ExpenceListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Book item, int position, int itemCount) {
            binding.tvBillNo.setText("Bill No.: " + item.title);
            // You can set other views from the binding object as needed.
        }
    }
}