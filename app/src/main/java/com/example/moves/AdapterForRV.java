package com.example.moves;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

import java.util.List;

public class AdapterForRV  extends RecyclerView.Adapter<AdapterForRV.Myviewholder> {

    List<User> cards;
    Context con;

    public AdapterForRV(List<User> cards ,Context con) {
        this.cards = cards;
        this.con=con;
    }

    @NonNull
    @Override
    public Myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem,parent,false);
        Myviewholder myviewholder =new Myviewholder(view);
        return myviewholder;

    }

    @Override
    public void onBindViewHolder(@NonNull Myviewholder holder, int position) {
        User card =cards.get(position);
        DrawableCrossFadeFactory drawableCrossFadeFactory= new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
        Glide.with(con)
                .load(card.getImageurl())
                .fitCenter()
                .transition(withCrossFade(drawableCrossFadeFactory))
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .fallback(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        holder.movename.setText(card.getName());
        holder.relname.setText(card.getRealname());

   holder.itemView.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent =new Intent(con,MovesDetails.class);
           intent.putExtra("heroname",cards.get(holder.getAdapterPosition()).getName());
           intent.putExtra("herorealname",cards.get(holder.getAdapterPosition()).getRealname());
           intent.putExtra("heroimage",cards.get(holder.getAdapterPosition()).getImageurl());
           intent.putExtra("herobio",cards.get(holder.getAdapterPosition()).getBio());
           con.startActivity(intent);
       }
   });





    }

    @Override
    public int getItemCount() {

        return cards.size();
    }


    class Myviewholder extends RecyclerView.ViewHolder{

        TextView movename;
        TextView relname;
        ImageView imageView;

        public Myviewholder(@NonNull View itemView) {
            super(itemView);
            this.movename=itemView.findViewById(R.id.name);
            this.relname = itemView.findViewById(R.id.realname);
            this.imageView = itemView.findViewById(R.id.product_img);
        }
}}
