package com.example.moves;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public class MovesDetails extends AppCompatActivity {
    TextView realname,heroname,herobio;
    ImageView heroimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moves_details);

        realname=findViewById(R.id.realname);
        heroname=findViewById(R.id.heroname);
        herobio=findViewById(R.id.herobio);
        heroimage=findViewById(R.id.heroimage);


        Intent intent=getIntent();
        Bundle bundle =intent.getExtras();
        DrawableCrossFadeFactory drawableCrossFadeFactory= new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        Glide.with(this)
                .load(bundle.getString("heroimage"))
                .transition(withCrossFade(drawableCrossFadeFactory))
                .into(heroimage);


        heroname.setText(bundle.getString("heroname"));
        realname.setText(bundle.getString("herorealname"));
        herobio.setText(bundle.getString("herobio"));




    }
}