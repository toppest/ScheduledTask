package com.toppest.scheduledtask;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class ScheduledTaskActivity extends Activity {
	
	static String TAG = "MyALARMTest";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    
    private void cleanNotification()
    {
		NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);		
		notificationManager.cancel(0);
    }
    
    //do your scheduled task here
    private void doTask()
    {
		String url = "http://www.google.com";
    	final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
    	startActivity(intent);   
    }
    
    
    public void onResume()
    {
    	Log.d(TAG, "onResume");
    	
    	cleanNotification();
    	
    	try
    	{
            AlarmUtility.setupAlarm(this);
	        doTask();	
	    	super.onResume();
    	}
    	catch(Exception e)
    	{
    		Log.d(TAG, e.getMessage());
    	}
    }
}