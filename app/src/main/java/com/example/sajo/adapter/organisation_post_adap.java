package com.example.sajo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sajo.R;
import com.example.sajo.data.model.organisation_post;

import java.util.List;

public class organisation_post_adap extends RecyclerView.Adapter<organisation_post_adap.Viewholder>
{
    Context context ;
    List<organisation_post> organisation_posts ;

    public organisation_post_adap(Context context, List<organisation_post> organisation_posts) {
        this.context = context;
        this.organisation_posts = organisation_posts;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.posts_card_design,parent,false);

        return new organisation_post_adap.Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

        organisation_post organisation_post = organisation_posts.get(position);

        holder.featureImage.setImageResource(R.drawable.display_img);
        holder.title.setText(organisation_post.getTitle());
        holder.desc.setText(organisation_post.getDesc());

    }

    @Override
    public int getItemCount() {
        return organisation_posts.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder
    {
        ImageView featureImage ;
        TextView title , desc ;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            featureImage = itemView.findViewById(R.id.featured_image);
            title= itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);

        }


    }
}
