package com.ttu.idk1606.cards.app.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.imanoweb.calendarview.CustomCalendarView;
import com.imanoweb.calendarview.DayDecorator;
import com.imanoweb.calendarview.DayView;
import com.ttu.idk1606.cards.app.R;
import com.ttu.idk1606.cards.app.decorator.CurrentDayDecorator;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by SarahMarion on 3.05.2016.
 */
public class CardCustomCalendarView extends CustomCalendarView {

    public CardCustomCalendarView(Context mContext) { this(mContext, null); }

    public CardCustomCalendarView(Context mContext, AttributeSet attrs) {
        super(mContext, attrs);
        setDateDecorators();
        localizeCalendar();
    }

    @Override
    public void refreshCalendar(Calendar currentCalendar) {
        super.refreshCalendar(currentCalendar);
        updateTitleLayout();
    }

    private void setDateDecorators() {
        List<DayDecorator> decorators = new ArrayList<DayDecorator>();
        decorators.add(new CurrentDayDecorator());
        setDecorators(decorators);
    }

    private void localizeCalendar() {
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());
        setFirstDayOfWeek(Calendar.MONDAY);
        refreshCalendar(currentCalendar);
    }

    private void updateTitleLayout() {
        updatePreviousMonthButton();
        updateNextMonthButton();
    }

    private void updatePreviousMonthButton() {
        ImageView previousMonthButton = (ImageView)this.findViewById(com.imanoweb.calendarview.R.id.leftButton);
        previousMonthButton.setImageResource(R.drawable.arrow_up);
        updateMonthNavigationButton(previousMonthButton);
        previousMonthButton.setRotation(-90);
    }

    private void updateNextMonthButton() {
        ImageView nextMonthButton = (ImageView)this.findViewById(com.imanoweb.calendarview.R.id.rightButton);
        nextMonthButton.setImageResource(R.drawable.arrow_up);
        updateMonthNavigationButton(nextMonthButton);
        nextMonthButton.setRotation(90);
    }

    private void updateMonthNavigationButton(ImageView button) {
        button.setScaleX(0.5f);
        button.setScaleY(0.5f);
        button.setColorFilter(R.color.light_purple, PorterDuff.Mode.SRC_IN);
        button.setImageAlpha(70);
    }

}
