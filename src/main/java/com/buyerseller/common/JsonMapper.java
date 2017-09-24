package com.buyerseller.common;

import java.io.IOException;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Component
public class JsonMapper
{
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * @param content content
     * @param valueType valueType
     * @return T
     * @throws JsonParseException JsonParseException
     * @throws JsonMappingException JsonMappingException
     * @throws IOException IOException
     */
    public <T> T jsonToObject(String content, Class<T> valueType)
            throws JsonParseException, JsonMappingException, IOException
    {
        return mapper.readValue(content, valueType);
    }

    /**
     * @param object object
     * @param content content
     * @param valueType valueType
     * @return T
     * @throws JsonGenerationException JsonGenerationException
     * @throws JsonParseException JsonParseException
     * @throws JsonMappingException JsonMappingException
     * @throws IOException IOException
     */
    public <T> String objectToJson(T object)
            throws JsonGenerationException, JsonMappingException, IOException
    {
        return mapper.writeValueAsString(object);
    }
}
