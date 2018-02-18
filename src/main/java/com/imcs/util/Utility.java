package com.imcs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	public static Date getDate(String date)throws Exception {
		return new SimpleDateFormat("MM/dd/yyyy").parse(date);
	}
}
