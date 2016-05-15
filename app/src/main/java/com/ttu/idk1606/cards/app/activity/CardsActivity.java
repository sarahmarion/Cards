package com.ttu.idk1606.cards.app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.ttu.idk1606.cards.app.R;
import com.ttu.idk1606.cards.app.adapter.CardAdapter;

public class CardsActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);

        Bundle b = getIntent().getExtras();
        String category = b.getString("category");

        final GridView gridView = (GridView) findViewById(R.id.cards);
        gridView.setAdapter(new CardAdapter(this, category));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CardActivity.class);
                intent.putExtra("imagePath", (String) gridView.getItemAtPosition(position));
                startActivity(intent);
            }

        });
    }

}
