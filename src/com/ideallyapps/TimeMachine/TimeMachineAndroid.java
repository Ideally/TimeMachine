package com.ideallyapps.TimeMachine;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * TimeMachineAndroid is a convenience class used which can work with Android Preferences
 * 
 * @see com.ideallyapps.TimeMachine.TimeMachineAbstract
 * 
 * @author davidwparker
 * @version 0.1
 */
public class TimeMachineAndroid extends TimeMachineAbstract {

	/**
	 * Singleton pattern
	 */
	private TimeMachineAndroid() {
	}

	private static class TimeMachineHolder {
		public static final TimeMachineAndroid instance = new TimeMachineAndroid();
	}

	public static TimeMachineAndroid getInstance() {
		return TimeMachineHolder.instance;
	}

	public Context mContext;

	public void setContext(final Context context) {
		mContext = context;
	}

	/**
	 * This method overrides the normal one. Instead the preferred date format is retrieved
	 * from the shared preferences in Android.
	 * 
	 * @see com.ideallyapps.TimeMachine.TimeMachineAbstract#getPrefDateFormatValue()
	 */
	@Override
	public int getPrefDateFormatValue() {
		return Integer.valueOf(PreferenceManager.getDefaultSharedPreferences(mContext).getString(
				mPreferredDateFormat, mPreferredDateFormatDefault));
	}
}
