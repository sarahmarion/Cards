package com.ttu.idk1606.cards.app.adapter;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.ttu.idk1606.cards.app.R;
import com.ttu.idk1606.cards.app.view.SquareImageView;

import java.util.Arrays;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private final Context context;

    public CategoryAdapter(Context context) {
        this.context = context;
    }

    private static final List<Integer> RESOURCES = Arrays.asList(R.drawable.christmas, R.drawable.newyear, R.drawable.valentine, R.drawable.easter, R.drawable.birthday);
    private static final List<String> CATEGORIES = Arrays.asList("christmas", "newyear", "valentine", "easter", "birthday");

    @Override
    public int getCount() {
        return RESOURCES.size();
    }

    @Override
    public Object getItem(int position) {
        return CATEGORIES.get(position);
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

        SquareImageView imageView = new SquareImageView(parent.getContext());
        imageView.setPadding(100,100,100,100);
        if (position % 4 == 0 || (position + 1) % 4 == 0) {
            imageView.setBackgroundResource(R.color.medium_purple);
        }

        Drawable image = ResourcesCompat.getDrawable(context.getResources(), RESOURCES.get(position), null);
        image.mutate().setColorFilter(context.getResources().getColor(R.color.light_purple), PorterDuff.Mode.SRC_ATOP);
        imageView.setImageDrawable(image);

        return imageView;
    }

}
