package com.sharif.terminator;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    private final TextView name;
    private final TextView instructor;
    private final CardView cardView;

    public TextView getName() {
        return name;
    }

    public TextView getInstructor() {
        return instructor;
    }

    public CardView getCardView() {
        return cardView;
    }

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
        instructor = (TextView) itemView.findViewById(R.id.instructor);
        this.cardView = itemView.findViewById(R.id.card_view);
    }
}