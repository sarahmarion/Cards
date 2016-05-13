package com.ttu.idk1606.cards.app.view;

import android.content.Context;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.imanoweb.calendarview.CalendarListener;
import com.imanoweb.calendarview.CustomCalendarView;
import com.imanoweb.calendarview.DayDecorator;
import com.ttu.idk1606.cards.app.R;
import com.ttu.idk1606.cards.app.decorator.CurrentDayDecorator;

import java.util.*;

public class CardCustomCalendarView extends CustomCalendarView {

    public CardCustomCalendarView(Context mContext) { this(mContext, null); }

    public CardCustomCalendarView(Context mContext, AttributeSet attrs) {
        super(mContext, attrs);
        setDateDecorators();
        localizeCalendar();
        addListeners();
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

    private void addListeners() {
        setCalendarListener(new CalendarListener() {

            @Override
            public void onDateSelected(Date date) {
                restoreCurrentDay();
                updateSelectedDate(date);
            }

            @Override
            public void onMonthChanged(Date date) {

            }

        });
    }

    private void updateSelectedDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        getDateView(cal).setBackgroundResource(R.drawable.circle_line);
    }

    private void restoreCurrentDay() {
        getDateView(getCurrentCalendar()).setBackgroundResource(R.drawable.circle);
    }

    private View getDateView(Calendar calendar) {
        int index = getDayIndexByDate(calendar);
        return findViewWithTag("dayOfMonthText" + index);
    }

    private int getDayIndexByDate(Calendar currentCalendar) {
        int monthOffset = this.getMonthOffset(currentCalendar);
        int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
        return currentDay + monthOffset;
    }

    private int getMonthOffset(Calendar currentCalendar) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(getFirstDayOfWeek());
        calendar.setTime(currentCalendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int firstDayWeekPosition = calendar.getFirstDayOfWeek();
        int dayPosition = calendar.get(Calendar.DAY_OF_WEEK);
        return firstDayWeekPosition == 1?dayPosition - 1:(dayPosition == 1?6:dayPosition - 2);
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
