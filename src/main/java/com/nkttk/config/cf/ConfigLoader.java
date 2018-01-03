package com.nkttk.config.cf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 */
public class ConfigLoader {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static CloudFormationConfig loadConfig(InputStream source) throws IOException {
        CloudFormationConfig cf = objectMapper.readValue(source, CloudFormationConfig.class);
        return cf;
    }
}
