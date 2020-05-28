package com.prismamp.consultas.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>
{
	private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String marshal(Date v) throws Exception
	{
		synchronized (dateFormat)
		{
			return dateFormat.format(v);
		}
	}

	public Date unmarshal(String v) throws Exception
	{
		synchronized (dateFormat)
		{
			return dateFormat.parse(v);
		}
	}
}
