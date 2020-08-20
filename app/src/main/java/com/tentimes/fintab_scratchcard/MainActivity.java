package com.tentimes.fintab_scratchcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.myinnos.androidscratchcard.ScratchCard;

public class MainActivity extends AppCompatActivity {

    ImageView image_close_button;
    ScratchCard scratchCard;
    CardView card_share;
    TextView card_textview,scratch_text,won_text,scratch_the_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }
        scratchCard=findViewById(R.id.scratchCard);
        image_close_button=findViewById(R.id.image_close_button);
        card_share=findViewById(R.id.card_share);
        card_textview=findViewById(R.id.text_card_share);
        scratch_text=findViewById(R.id.scratch_text);
        won_text=findViewById(R.id.won_text);
        scratch_the_card=findViewById(R.id.scratch_the_card);

        scratchCard.setScratchDrawable(getResources().getDrawable(R.drawable.ic_place_holder));
        scratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.3) {
                    scratchCard.setVisibility(View.GONE);
                    won_text.setText("Gold worth Rs.10 will be added to your Digital Gold balance");
                    scratch_text.setVisibility(View.INVISIBLE);
                    card_share.setCardBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    card_textview.setTextColor(getResources().getColor(R.color.white));
                    scratch_the_card.setVisibility(View.INVISIBLE);
                    //Toast.makeText(MainActivity.this, "Content Visible", Toast.LENGTH_SHORT).show();
                }
            }
        });
        image_close_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
