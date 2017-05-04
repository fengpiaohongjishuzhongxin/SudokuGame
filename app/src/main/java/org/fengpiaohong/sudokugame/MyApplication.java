package org.fengpiaohong.sudokugame;

import android.app.Application;
import android.content.*;

public class MyApplication extends Application
{
	
	private static Context context;
	@Override
	public void onCreate()
	{
		// TODO: Implement this method
		context = getApplicationContext();
	}
	
	public static Context grtContext(){
		return context;
	}
	
}
