package com.sri.prac.Convertor;

import java.util.Arrays;
import java.util.List;
import java.util.*;


import javax.persistence.AttributeConverter;

import org.dom4j.dom.DOMNodeHelper.EmptyNodeList;
//class to convert list of coursesOfffered strings to a  string 
public class StringListConverter implements AttributeConverter<List<String>, String> {			
	
private static final String SPLIT_CHAR = ",";
    
    @Override
    public String convertToDatabaseColumn(List<String> stringList) {
        return stringList != null ? String.join(SPLIT_CHAR, stringList) : "";
    }

    @Override
    public List<String> convertToEntityAttribute(String string) {
        return string != null ? Arrays.asList(string.split(SPLIT_CHAR)) :Collections.emptyList();
    }
}
