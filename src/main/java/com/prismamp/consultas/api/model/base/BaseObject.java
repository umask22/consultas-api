package com.prismamp.consultas.api.model.base;

import java.lang.reflect.Field;
import java.util.Arrays;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.prismamp.consultas.api.util.SecurityUtil;

public class BaseObject
{
	public String toString()
	{
		ReflectionToStringBuilder builder = new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
		{
			@Override
			protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException
			{
				if (Arrays.asList(SecurityUtil.ATRIBUTOS_OCULTOS).contains(field.getName()))
				{
					return "[WIPED]";
				}
				else if (Arrays.asList(SecurityUtil.ATRIBUTOS_ENMASCARADOS).contains(field.getName()) && field.getType().equals(String.class))
				{
					String valorAEnmascarar = (String) field.get(getObject());
					return SecurityUtil.protect(valorAEnmascarar);
				}
				else
				{
					return field.get(getObject());
				}
			}
		};
		return builder.toString();
	}
}
