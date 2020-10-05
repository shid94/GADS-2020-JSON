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

public class SkillIqAdpater extends RecyclerView.Adapter<SkillIqAdpater.SkillIqViewHolder>{
    private static final String URL_DATA = "https://gadsapi.herokuapp.com/api/hours";
    private ArrayList<SkillIqItem> mSkillIqList;


    public  static class SkillIqViewHolder  extends  RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mTextView4;
        public  TextView mTextView5;
        public TextView mTextView6;

        public SkillIqViewHolder(@NonNull View itemView) {
            super(itemView);
             mImageView = itemView.findViewById(R.id.imageView2);
             mTextView4 = itemView.findViewById(R.id.textView4);
             mTextView5 = itemView.findViewById(R.id.textView5);
             mTextView6 = itemView.findViewById(R.id.textView6);
        }
    }
    public SkillIqAdpater(ArrayList<SkillIqItem> skillIqList){
        mSkillIqList = skillIqList;

    }

    @NonNull
    @Override
    public SkillIqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.skill_iq_items, parent, false);
     SkillIqViewHolder svh = new SkillIqViewHolder(v);
     return  svh;
    }

    @Override
    public void onBindViewHolder(@NonNull SkillIqViewHolder holder, int position) {
        SkillIqItem currentItem = mSkillIqList.get(position);
        Picasso.get().load(mSkillIqList.get(position).getImagaResource()).into(holder.mImageView);
        holder.mTextView4.setText(currentItem.getName());
        holder.mTextView5.setText(currentItem.getPoints());
        holder.mTextView6.setText(currentItem.getCountry());

    }

    @Override
    public int getItemCount() {
        return mSkillIqList.size();
    }
}
