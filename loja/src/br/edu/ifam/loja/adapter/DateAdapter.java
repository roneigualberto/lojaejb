package br.edu.ifam.loja.adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Calendar> {
	
	private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public String marshal(Calendar value) throws Exception {
		return format.format(value.getTime());
	}

	@Override
	public Calendar unmarshal(String value) throws Exception {
		Calendar instance = Calendar.getInstance();
		Date data = format.parse(value);
		instance.setTime(data);
		return instance;
	}

}
