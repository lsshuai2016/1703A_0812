package com.liushaoshuai.liushaoshuai_user.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class DateUtil {
	
	/**
	 * @Title: randomDate 
	 * @Description: 返回在某个日期区间的随机日期
	 * @param startDate
	 * @return
	 * @return: Date
	 * @throws ParseException 
	 */
	public static Date randomDate(Date startDate) throws ParseException {
		//用当前时间获取日历类
		Calendar c = Calendar.getInstance();
		c.setTime(new SimpleDateFormat("yyyy-MM-dd").parse("2001-01-01"));
		//当前时间的毫秒值，即从1970到现在的毫秒数
		long endMillis = c.getTimeInMillis();
		//用传入的日期初始化日历类Calendar
		c.setTime(startDate);
		long startMillis = c.getTimeInMillis();
		long x = (long)(Math.random()*(endMillis-startMillis+1))+startMillis;
		//用时间差创建日历类
		c.setTimeInMillis(x);
		return c.getTime();
		
	}
	
	/**
	 * @Title: getDateByInitMonth 
	 * @Description: 返回月初
	 * 方法1：(5分)
	 * 给一个时间对象，返回该时间所在月的1日0时0分0秒。例如一个Date对象的值是2019-05-18 11:37:22
	* 则返回的结果为2019-05-01 00:00:00
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static Date getDateByInitMonth(Date src) {
		//获取Calendar对象
		Calendar c = Calendar.getInstance();
		//用传入的时间初始化日历对象
		c.setTime(src);
		//改变日期的日，时，分，秒
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		return c.getTime();
	}
	
	/**
	 * 
	 * @Title: getDateByFullMonth 
	 * @Description: 返回月末
	* 方法2：(5分)
	* 给一个时间对象，返回该时间所在月的最后日23时59分59秒，需要考虑月大月小和二月特殊情况。
	* 例如一个Date对象的值是2019-05-18 11:37:22，则返回的时间为2019-05-31 23:59:59
	* 例如一个Date对象的值是2019-02-05 15:42:18，则返回的时间为2019-02-28 23:59:59
	
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static Date getDateByFullMonth(Date src) {
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		c.add(Calendar.MONTH, 1);
		Date monthStart = getDateByInitMonth(c.getTime());
		c.setTime(monthStart);
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}
	
	
	
	
	
}
