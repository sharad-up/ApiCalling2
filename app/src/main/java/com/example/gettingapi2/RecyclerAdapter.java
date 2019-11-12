package com.example.gettingapi2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;


import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.jar.Attributes;

public class RecyclerAdapter extends RecyclerView.Adapter <RecyclerAdapter.MyViewholder>{

    private List<Countrymodel> countrymodels;
    public RecyclerAdapter(List<Countrymodel> countrymodels){
        this.countrymodels=countrymodels;
    }

    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list,parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.Name.setText(countrymodels.get(position).getName());
        holder.Code.setText(countrymodels.get(position).getCode());
    }


    @Override
    public int getItemCount() {
        return  countrymodels.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView Name,Code;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            Name=(TextView)itemView.findViewById(R.id.name);
            Code=(TextView)itemView.findViewById(R.id.email);
        }


        public void bindData(){

        }
    }
}
