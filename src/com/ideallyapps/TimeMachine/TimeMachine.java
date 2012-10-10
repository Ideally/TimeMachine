package com.ideallyapps.TimeMachine;

/**
 * TimeMachine is a convenience class for TimeMachine functionality.
 * 
 * @see com.ideallyapps.TimeMachine.TimeMachineAbstract
 * 
 * @author davidwparker
 * @version 0.1
 */
public class TimeMachine extends TimeMachineAbstract {

	/**
	 * Singleton pattern
	 */
	private TimeMachine() {
	}

	private static class TimeMachineHolder {
		public static final TimeMachine instance = new TimeMachine();
	}

	public static TimeMachine getInstance() {
		return TimeMachineHolder.instance;
	}

}
