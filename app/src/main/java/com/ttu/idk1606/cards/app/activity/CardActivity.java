package com.ttu.idk1606.cards.app.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.ttu.idk1606.cards.app.R;

public class CardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view);

        setImage();
        handleEventNext();
        handleEventBack();
    }

    private void handleEventBack() {
        final TextView back = (TextView) findViewById(R.id.menu_back);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }

    private void handleEventNext() {
        final TextView next = (TextView) findViewById(R.id.menu_next);
        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SendActivity.class);
                startActivity(intent);
            }

        });
    }

    private void setImage() {
        Bundle b = getIntent().getExtras();
        String imagePath = b.getString("imagePath");

        final ImageView card = (ImageView) findViewById(R.id.card);
        card.setImageURI(Uri.parse(imagePath));
    }

}
