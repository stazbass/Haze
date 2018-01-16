package com.nkttk.haze.config.cf;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 */
public class ConfigParser {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public CloudFormationConfig loadConfig(InputStream source) throws IOException {
        CloudFormationConfig cf = objectMapper.readValue(source, CloudFormationConfig.class);
        return cf;
    }
}
