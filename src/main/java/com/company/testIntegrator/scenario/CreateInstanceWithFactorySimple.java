package com.company.testIntegrator.scenario;

import com.company.testIntegrator.customPropagator.CustomPropagator;
import com.decathlon.connectJavaIntegrator.factory.RFIDConnectConnectorFactorySimple;
import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;

/**
 * Created by Jonathan on 29/03/2019.
 */
public class CreateInstanceWithFactorySimple {

    RFIDConnectJavaMqttInstance connectInstance;

    /**
     *     use connectInstance with simple factory to demonstrate how to add only one lister
     */
    public CreateInstanceWithFactorySimple() {
        try {
            this.connectInstance = RFIDConnectConnectorFactorySimple.getInstance();
            RFIDConnectConnectorFactorySimple.registerNewListener(new CustomPropagator());
            //connectInstance.sendCommand(ConnectCommandToSend());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
