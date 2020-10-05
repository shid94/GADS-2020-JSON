package com.richard.myapplication4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class LearningAdapter extends RecyclerView.Adapter<LearningAdapter.LearningViewHolder> {
    LayoutInflater inflater;
    private  ArrayList<LearningItem> mLearningList;



    public static class LearningViewHolder extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView1;
        public  TextView mTextView2;
        public TextView mTextView3;

        public LearningViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViews);
            mTextView1 = itemView.findViewById(R.id.textView1);
            mTextView2 = itemView.findViewById(R.id.textView2);
            mTextView3 = itemView.findViewById(R.id.textView3);
        }
    }
    public  LearningAdapter(ArrayList<LearningItem> learningList){
        mLearningList = learningList;

    }

    @NonNull
    @Override
    public LearningViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.learning_items, parent,false);
        LearningViewHolder Lvh = new LearningViewHolder(v);
        return Lvh;

    }

    @Override
    public void onBindViewHolder(@NonNull LearningViewHolder holder, int position) {
    LearningItem currentItem = mLearningList.get(position);
    holder.mTextView1.setText(currentItem.getName());
    holder.mTextView2.setText(currentItem.getLearningHours());
    holder.mTextView3.setText(currentItem.getCountry());
    Picasso.get().load(mLearningList.get(position).getImageResource()).into(holder.mImageView);


    }

    @Override
    public int getItemCount() {
        return mLearningList.size();
    }
}
