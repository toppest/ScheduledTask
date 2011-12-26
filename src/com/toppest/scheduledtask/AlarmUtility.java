package com.toppest.scheduledtask;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmUtility {
	
	static public void setupAlarm(Context context)
	{
        Intent receiverIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, receiverIntent, 0);
        
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    	    
        Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 7);
        cal.set(Calendar.MINUTE, 30);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    
        long triggerTime = cal.getTimeInMillis();
    
        am.set(AlarmManager.RTC_WAKEUP, triggerTime, sender);
	}
}
