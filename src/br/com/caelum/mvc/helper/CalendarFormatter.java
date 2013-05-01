package br.com.caelum.mvc.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarFormatter {

	public String formatCalendar(Calendar calendar){
		Date time = calendar.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		return formatter.format(time);
	}
	
}
