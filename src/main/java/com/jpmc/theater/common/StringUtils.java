package com.jpmc.theater.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class StringUtils {
    public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes( hour );

        return String.format( "%s hour%s %s minute%s", hour, handlePlural( hour ), remainingMin, handlePlural( remainingMin ) );
    }

    private static String handlePlural(final long value) {
        return value == 1 ? "" : "s";
    }

    public static String stringToJson(Object object){
        ObjectMapper mapper = JsonMapper.builder()
                .addModule(new ParameterNamesModule() )
                .addModule(new Jdk8Module() )
                .addModule(new JavaTimeModule() )
                .build();

        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(object);
        } catch (JsonProcessingException exception) {
            exception.printStackTrace();
        }
        return jsonString;
    }
}