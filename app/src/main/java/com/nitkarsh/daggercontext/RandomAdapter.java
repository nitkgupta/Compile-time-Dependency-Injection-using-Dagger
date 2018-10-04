package com.nitkarsh.daggercontext;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RandomAdapter extends RecyclerView.Adapter<RandomAdapter.ViewHolder> {
    private Context context;
    private List<RetroData> retroData;
    TextView etId,etName,etEmail;
    public RandomAdapter(Context context, List<RetroData> list) {
        this.context=context;
        retroData=list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.view_recycler,parent,false);
        ViewHolder mHolder=new ViewHolder(view);

        return mHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        etId=holder.etId;
        etName=holder.etName;
        etEmail=holder.etEmail;
        etId.setText(retroData.get(position).getId());
        etName.setText(retroData.get(position).getName());
        etEmail.setText(retroData.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etId,etName,etEmail;
        ViewHolder(View view){
            super(view);
            etId=itemView.findViewById(R.id.etId);
            etName=itemView.findViewById(R.id.etName);
            etEmail=itemView.findViewById(R.id.etEmail);
        }
    }
}
