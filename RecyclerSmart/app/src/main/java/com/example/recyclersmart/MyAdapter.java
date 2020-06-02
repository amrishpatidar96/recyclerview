package com.example.recyclersmart;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    private List<NatureModel> objectList ;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<NatureModel> objectList)
    {
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NatureModel current = objectList.get(position);
        holder.setData(current,position);
        
    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder
    {   private TextView title ;
        private ImageView imgThumb,imgDelete,imgCopy;
        private int position ;
        private NatureModel currentObject;



        public MyViewHolder(View itemView){
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_thumb);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_delete);
            imgCopy = (ImageView) itemView.findViewById(R.id.img_copy);
        }

        public void setData(NatureModel currentObject, int position) {

            this.title.setText(currentObject.getTitle());
            this.imgThumb.setImageResource(currentObject.getImageID());
            this.position = position ;
            this.currentObject = currentObject;
        }
    }
}
