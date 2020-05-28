package com.prismamp.consultas.api.util;

import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper
{
	public CustomObjectMapper()
	{
		super();
		disable(Feature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
}
