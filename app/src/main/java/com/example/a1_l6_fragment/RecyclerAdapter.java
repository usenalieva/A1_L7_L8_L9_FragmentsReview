package com.example.a1_l6_fragment;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class  RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<DestinationModel> list;
    private Context context;
    private IFragments listener;

    public RecyclerAdapter(ArrayList<DestinationModel > list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(parent.getContext());
        View view =  layoutInflater.inflate(R.layout.list_item_for_rec_view,parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
    holder.onBind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class RecyclerViewHolder  extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_title;
        private TextView tv_desc;
        private ImageView ivImage;

       DestinationModel model;
        int pos = 0;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_title =itemView.findViewById(R.id.tvTitle);
            tv_desc  = itemView.findViewById(R.id.tvDesc);
            ivImage =itemView.findViewById(R.id.img_row);

        }
        private void onBind(DestinationModel model, int pos) {
        this.pos = pos;
        this.model = model;
        tv_title.setText(model.getTitle());
        tv_desc.setText(model.getDesc());
        ivImage.setImageURI(Uri.parse(model.getImage()));
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.displayDetails(model.getTitle(), model.getDesc());
            }
        }
    }

    public  void setOnCLickListener (IFragments mListener) {
        this.listener = mListener;
    }
}
