package com.ttu.idk1606.cards.app.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.ttu.idk1606.cards.app.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class CardAdapter extends BaseAdapter {

    private final Context context;
    private final String category;
    private final List<String> cards;

    public CardAdapter(Context context, String category) {
        this.context = context;
        this.category = category;
        this.cards = getCards();
    }

    @Override
    public int getCount() {
        return cards.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView != null) {
            return convertView;
        }

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageView imageView = (ImageView) inflater.inflate(R.layout.card, null);
        imageView.setImageURI(Uri.parse("android.resource://" + context.getPackageName() + "/drawable/" + cards.get(position)));
        return imageView;
    }

    private List<String> getCards() {
        Field[] fields = R.drawable.class.getFields();
        List<String> drawables = new ArrayList<String>();
        for (Field field : fields) {
            if (field.getName().startsWith(category) && !field.getName().equals(category)) {
                drawables.add(field.getName());
            }
        }
        return drawables;
    }
}
