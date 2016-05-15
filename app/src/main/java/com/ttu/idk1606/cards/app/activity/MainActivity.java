package com.ttu.idk1606.cards.app.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import com.ttu.idk1606.cards.app.R;
import com.ttu.idk1606.cards.app.activity.CardsActivity;
import com.ttu.idk1606.cards.app.adapter.CategoryAdapter;

public class MainActivity extends AppCompatActivity {

    private int view = R.layout.categories;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createCategoryView();
    }

    private void createCategoryView() {
        setContentView(view);

        final GridView gridView = (GridView) findViewById(R.id.categories);
        gridView.setAdapter(new CategoryAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), CardsActivity.class);
                intent.putExtra("category", (String) gridView.getItemAtPosition(position));
                startActivity(intent);
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (view == R.layout.calendar) {
            view = R.layout.categories;
            createCategoryView();
        } else {
            view = R.layout.calendar;
            setContentView(view);
        }
        return true;
    }
}
