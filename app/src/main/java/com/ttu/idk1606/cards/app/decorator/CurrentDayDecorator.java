package com.ttu.idk1606.cards.app.decorator;

import com.imanoweb.calendarview.CustomCalendarView;
import com.imanoweb.calendarview.DayDecorator;
import com.imanoweb.calendarview.DayView;
import com.ttu.idk1606.cards.app.R;

import java.util.Calendar;

/**
 * Created by SarahMarion on 5.05.2016.
 */
public class CurrentDayDecorator implements DayDecorator {

    @Override
    public void decorate(DayView dayView) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dayView.getDate());
        boolean isToday = CustomCalendarView.isToday(cal);
        if (isToday) {
            dayView.setBackgroundResource(R.drawable.circle);
        }
    }
}
