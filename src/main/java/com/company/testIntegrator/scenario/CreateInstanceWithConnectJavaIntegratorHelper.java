package com.company.testIntegrator.scenario;

import com.company.testIntegrator.customPropagator.CustomPropagator;
import com.decathlon.connectJavaIntegrator.configurator.CJIFluentConfigurator;
import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.receiveFromConnectJava.listener.IRFIDConnectEventPropagator;

/**
 * Created by Jonathan on 29/03/2019.
 */
public class CreateInstanceWithConnectJavaIntegratorHelper {

    RFIDConnectJavaMqttInstance connectInstance;

    /**
     * create connectInstance with ConnectJavaIntegratorHelper that simplify syntax
     */
    public CreateInstanceWithConnectJavaIntegratorHelper() {
        this.connectInstance = new CJIFluentConfigurator()
                .removeDefautlListener()
                .addListener(CustomPropagator.class.toString(), (IRFIDConnectEventPropagator) new CustomPropagator())
                .returnInstance();
    }

    public RFIDConnectJavaMqttInstance getConnectInstance() {
        return connectInstance;
    }
}
