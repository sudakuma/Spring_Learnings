package com.sudarshan.myapp.SpringBootApp.util;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author SUDARSHAN
 *
 */
public class AppUtil {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws JsonProcessingException
	 */
	public String convertToJson(List obj) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        return jsonInString;
    }
}
