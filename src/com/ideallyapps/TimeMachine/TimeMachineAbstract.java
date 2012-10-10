package com.ideallyapps.TimeMachine;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * TimeMachineAbstract is an abstract class for working with:
 * <ul>
 * <li>java.sql.TimeStamps</li>
 * <li>java.text.SimpleDateFormat</li>
 * <li>java.util.Calendar</li>
 * </ul>
 * 
 * @author davidwparker
 * @version 0.1
 */
public abstract class TimeMachineAbstract {

	public String mPreferredDateFormat = "0";
	public String mPreferredDateFormatDefault = "0";
	public String[] mDateArrayFormat = { "MM/dd/yyyy", "dd/MM/yyyy", "yyyy/MM/dd" };
	public String mPreferredDivider = "/";
	public int mYear;
	public int mMonth;
	public int mDay;

	public void setPreferredDateFormat(final String preferredDateFormat) {
		mPreferredDateFormat = preferredDateFormat;
	}

	public void setPreferredDateFormatDefault(final String preferredDateFormatDefault) {
		mPreferredDateFormatDefault = preferredDateFormatDefault;
	}

	public void setDateArrayFormat(final String[] dateArrayFormat) {
		mDateArrayFormat = dateArrayFormat;
	}

	public void setPreferredDivider(final String preferredDivider) {
		mPreferredDivider = preferredDivider;
	}

	/**
	 * Set the date (Day, Month, Year) to today.
	 */
	public void setDateToday() {
		final Calendar c = Calendar.getInstance();
		setDate(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Set the date (Day, Month, Year) based on a long date value.
	 * 
	 * @param date
	 */
	public void setDate(final long date) {
		final Calendar c = Calendar.getInstance();
		c.setTimeInMillis(date);
		final int year = c.get(Calendar.YEAR);
		final int month = c.get(Calendar.MONTH);
		final int day = c.get(Calendar.DAY_OF_MONTH);
		setDate(year, month, day);
	}

	/**
	 * @param year
	 *            - int - year
	 * @param monthOfYear
	 *            - int - month (zero-based)
	 * @param dayOfMonth
	 *            - int - day
	 */
	public void setDate(final int year, final int monthOfYear, final int dayOfMonth) {
		setYear(year);
		setMonth(monthOfYear);
		setDay(dayOfMonth);
	}

	public int getYear() {
		return this.mYear;
	}

	public void setYear(final int year) {
		this.mYear = year;
	}

	public int getMonth() {
		return this.mMonth;
	}

	public void setMonth(final int monthOfYear) {
		this.mMonth = monthOfYear;
	}

	public int getDay() {
		return this.mDay;
	}

	public void setDay(final int dayOfMonth) {
		this.mDay = dayOfMonth;
	}

	/**
	 * Returns the integer value of the preferred date format, otherwise return the integer value of
	 * the default preferred date format.
	 * 
	 * @return the preferred date format value
	 */
	public int getPrefDateFormatValue() {
		return Integer.valueOf((mPreferredDateFormat != null
				? mPreferredDateFormat
				: mPreferredDateFormatDefault));
	}

	/**
	 * Get the actual preferred date format based on the currently set date format value.
	 * 
	 * @return the actual preferred date format
	 */
	public String getPrefDateFormat() {
		return mDateArrayFormat[getPrefDateFormatValue()];
	}

	/**
	 * Returns date as a String based on an input long in the given preferred format:
	 * <ul>
	 * <li>MM/dd/yyyy</li>
	 * <li>dd/MM/yyyy</li>
	 * <li>yyyy/MM/dd</li>
	 * </ul>
	 * 
	 * @param context
	 *            - Context - application context
	 * @param date
	 *            - long - value of date
	 * @param prefDate
	 *            - String - preference for date
	 * @param prefDateDef
	 *            - String - preference for date default
	 * @param dateEntries
	 *            - String[] - date entries
	 * @return <li>date as a string</li>
	 */
	public String getStringDateFromLong(final long date) {
		final Timestamp ts = new Timestamp(date);
		final String prefDateFormat = getPrefDateFormat();
		final SimpleDateFormat dateFormat = new SimpleDateFormat(prefDateFormat);
		return dateFormat.format(ts);
	}

	/**
	 * Returns the date as a string based on currently set Day, Month, and Year.
	 * 
	 * @return <li>date as a string</li>
	 */
	public String getStringDateFromDMY() {
		final StringBuilder sb = new StringBuilder();
		switch (getPrefDateFormatValue()) {
		case 0:
			sb.append(mMonth + 1).append(mPreferredDivider).append(mDay).append(mPreferredDivider)
					.append(mYear);
			break;
		case 1:
			sb.append(mDay).append(mPreferredDivider).append(mMonth + 1).append(mPreferredDivider)
					.append(mYear);
			break;
		case 2:
			sb.append(mYear).append(mPreferredDivider).append(mMonth + 1).append(mPreferredDivider)
					.append(mDay);
			break;
		}
		return sb.toString();
	}

}
