package com.company.testIntegrator.utils;

import java.util.Properties;

/**
 * @author z21bcoll
 */
//@Log4j
public class RFIDProperties {

    /**
     * Properties hashmap.
     */
    static private Properties props = null;

    /**
     * Initialize.
     */
    static {
        props = new Properties();
        try {
            props.load(ClassLoader.getSystemResourceAsStream("application.properties"));

        } catch (Exception e) {
            //log.error("Exception : ", e);
        }
    }

    /**
     * Forces singleton.
     */
    private RFIDProperties() {
    }

    /**
     * Returns the Properties object instance.
     *
     * @param p Element of COMMAND_ACTION enumeration.
     * @return properties object
     */
    public static String getValue(PROPERTIES p) {

        return props.getProperty(p.toString()) != null ? props.getProperty(p.toString()).trim() : "";
    }

    /**
     * Enumeration for application properties.
     */
    public enum PROPERTIES {

        DEV_MODE("DEV_MODE"),

        LANGUAGE("LANGUAGE"),

        TCP_ADDRESS("TCP_ADDRESS"),

        TCP_PORT("TCP_PORT"),

        DEVICE_KEY("DEVICE_KEY"),
        DEVICE_NAME("DEVICE_NAME"),
        CONNECTION_TYPE("CONNECTION_TYPE"),
        STORE_WAREHOUSE_FACTORY_NUMBER("STORE_WAREHOUSE_FACTORY_NUMBER"),
        SECURE("SECURE"),
        BUSINESS_PROCESS("BUSINESS_PROCESS"),
        BUSINESS_PROCESS_REFERENCE("BUSINESS_PROCESS_REFERENCE"),
        BUFFER_TYPE("BUFFER_TYPE"),
        EAN_FILTER_LIST("EAN_FILTER_LIST"),
        FORCE_CLEAR_BUFFER("FORCE_CLEAR_BUFFER"),
        STOP_TYPE("STOP_TYPE");

        private String value;

        PROPERTIES(String v) {
            value = v;
        }

        /**
         * @see Enum#toString()
         */
        @Override
        public String toString() {
            return value;
        }
    }

}
