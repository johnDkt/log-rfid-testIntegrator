package com.company.testIntegrator.customPropagator;

import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.receiveFromConnectJava.listener.AbstractDefaultPropagatorListener;

/**
 * Created by Jonathan on 24/08/2018.
 */
public class CustomPropagator2 extends AbstractDefaultPropagatorListener {


    public Boolean isConnected() {
        System.out.println("custom2 yoo biloute t connecté!");
        return true;

    }

    public void getTags(String[] tags) {
        System.out.println("custom 2 ya des tags!");
    }

    public void error(String error) {
        System.out.println("custom 2 ta une putain d'erreur MAN!! " +error);
    }

}
