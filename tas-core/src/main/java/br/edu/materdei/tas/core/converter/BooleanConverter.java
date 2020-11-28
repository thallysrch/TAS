package br.edu.materdei.tas.core.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Convert;

@Convert
public class BooleanConverter implements AttributeConverter<Boolean, String>{

	@Override
	public String convertToDatabaseColumn(Boolean value) {
		return (Boolean.TRUE.equals(value) ? "S" : "N");
	}

	@Override
	public Boolean convertToEntityAttribute(String value) {
		return ( "V".equals(value) );
	}

}