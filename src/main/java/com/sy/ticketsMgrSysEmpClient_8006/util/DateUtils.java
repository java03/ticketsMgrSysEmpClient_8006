package com.sy.ticketsMgrSysEmpClient_8006.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 格式化的类
 * @author admin
 *
 */
public class DateUtils {
	private static SimpleDateFormat sdfYMD1 = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat sdfYMD2 = new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 格式化年月日的String
	 */
	public static Date parseYMDStr2Date(String ymdStr) {
		try {
			if( ymdStr.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				return sdfYMD1.parse(ymdStr);
				
			}else {
				return sdfYMD2.parse(ymdStr);
			}
		} catch (ParseException e) {
			
			e.printStackTrace();
			return new Date();
		}
	}
}