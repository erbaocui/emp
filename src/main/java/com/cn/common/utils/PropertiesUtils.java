package com.cn.common.utils;

/**
 * Created by home on 2017/8/8.
 */
import com.cn.util.ResourceLoader;

import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.DoubleAccumulator;

/**
 * 用ConcurrentMap来缓存属性文件的key-value
 */
public class PropertiesUtils {

    private static ResourceLoader loader = ResourceLoader.getInstance();
    private static ConcurrentMap<String, String> configMap = new ConcurrentHashMap<String, String>();
    private static final String DEFAULT_CONFIG_FILE = "test.properties";

    private static Properties prop = null;

    public static String getStringByKey(String key, String propName) {
        try {
            prop = loader.getPropFromProperties(propName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        key = key.trim();
        if (!configMap.containsKey(key)) {
            if (prop.getProperty(key) != null) {
                configMap.put(key, prop.getProperty(key));
            }
        }
        return configMap.get(key);
    }

    public static String getStringByKey(String key) {
        return getStringByKey(key, DEFAULT_CONFIG_FILE);
    }

    public static Double getDoubleByKey(String key, String propName) {
        try {
            prop = loader.getPropFromProperties(propName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        key = key.trim();
        if (!configMap.containsKey(key)) {
            if (prop.getProperty(key) != null) {
                configMap.put(key, prop.getProperty(key));
            }
        }
        return Double.valueOf(configMap.get(key));
    }

    public static Double getDoubleByKey(String key) {
        return getDoubleByKey(key, DEFAULT_CONFIG_FILE);
    }

    public static Integer getIntegerByKey(String key, String propName) {
        try {
            prop = loader.getPropFromProperties(propName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        key = key.trim();
        if (!configMap.containsKey(key)) {
            if (prop.getProperty(key) != null) {
                configMap.put(key, prop.getProperty(key));
            }
        }
        return Integer.valueOf(configMap.get(key));
    }
    public static Integer getIntegerByKey(String key) {
        return getIntegerByKey(key, DEFAULT_CONFIG_FILE);
    }

    public static Boolean getBooleanByKey(String key, String propName) {
        try {
            prop = loader.getPropFromProperties(propName);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        key = key.trim();
        if (!configMap.containsKey(key)) {
            if (prop.getProperty(key) != null) {
                configMap.put(key, prop.getProperty(key));
            }
        }
        return Boolean.valueOf(configMap.get(key));
    }
    public static Boolean getBooleanrByKey(String key) {
        return getBooleanByKey(key, DEFAULT_CONFIG_FILE);
    }

    public static Properties getProperties() {
        try {
            return loader.getPropFromProperties(DEFAULT_CONFIG_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}