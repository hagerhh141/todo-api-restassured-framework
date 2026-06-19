package com.todo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader
{
        private static final Properties properties = new Properties();

        static {
            try {
                InputStream inputStream = PropertyReader.class
                        .getClassLoader()
                        .getResourceAsStream("config.properties");

                if (inputStream == null) {
                    throw new RuntimeException("config.properties file not found");
                }

                properties.load(inputStream);

            } catch (IOException e) {
                throw new RuntimeException("Failed to load config.properties file", e);
            }
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
    }

