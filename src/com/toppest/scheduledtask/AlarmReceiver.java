package com.toppest.scheduledtask;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
	
	static String MSG = "Scheduled Task!";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub

		showNotification(context, MSG); //replace with the right message
	}

	private void showNotification(Context context, String msg)
	{
		Notification notification = new Notification(R.drawable.icon, MSG, System.currentTimeMillis());
		notification.flags = Notification.FLAG_NO_CLEAR;
		PendingIntent intent = PendingIntent.getActivity(context, 0, new Intent(context, ScheduledTaskActivity.class), 0);
		
		notification.setLatestEventInfo(context, msg, msg, intent);
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);		
		notificationManager.cancel(0);
		notificationManager.notify(0, notification);
	}
}
