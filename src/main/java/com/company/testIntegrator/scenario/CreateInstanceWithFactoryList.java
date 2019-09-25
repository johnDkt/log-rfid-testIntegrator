package com.company.testIntegrator.scenario;

import com.company.testIntegrator.customPropagator.CustomPropagator;
import com.company.testIntegrator.customPropagator.CustomPropagator2;
import com.company.testIntegrator.utils.LoggerImpl;
import com.decathlon.connectJavaIntegrator.factory.CJIListenerFactory;
import com.decathlon.connectJavaIntegrator.factory.CJILoggerFactory;
import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;

/**
 * Created by Jonathan on 29/03/2019.
 */
public class CreateInstanceWithFactoryList {

    RFIDConnectJavaMqttInstance connectInstance;

    /**
     *     use connectInstance with list factory and demonstrate how to add an infinity of listener
     */
    public CreateInstanceWithFactoryList() {

        CJILoggerFactory.setInstance(new LoggerImpl());
        try {
            //this.connectInstance = RFIDConnectConnectorFactoryList.getInstance();
            CJIListenerFactory.registerNewListener("listenerCustom1", new CustomPropagator());
            CJIListenerFactory.registerNewListener("listenerCustom2", new CustomPropagator2());
            CJIListenerFactory.removeDefaultListener();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
