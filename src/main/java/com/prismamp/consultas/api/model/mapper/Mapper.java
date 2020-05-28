package com.prismamp.consultas.api.model.mapper;

import com.prismamp.consultas.api.exception.ConsultasApiException;

public abstract class Mapper<S, T>
{
	public abstract T convert(S obj) throws ConsultasApiException;
}
