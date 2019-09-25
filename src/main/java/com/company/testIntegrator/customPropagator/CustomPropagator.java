package com.company.testIntegrator.customPropagator;

import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.receiveFromConnectJava.listener.AbstractDefaultPropagatorListener;

/**
 * Created by Jonathan on 24/08/2018.
 */

public class CustomPropagator extends AbstractDefaultPropagatorListener {

    public static boolean isConnected = false;
    public static boolean isError = false;

    public CustomPropagator() {

    }

    public Boolean isConnected(Boolean value) {
        if(value){
            System.out.println("je suis connecté!!");
            isError = false;
        }
        isConnected = value;
        return value;
    }

    public void getTags(String[] tags) {
        isError = false;
        System.out.println("ya des tags!");
        System.out.println(tags.toString());
    }

    public void error(String error) {
        System.out.println("ta une putain d'erreur mec!! " +error);
        if(!error.contains("-1")){
            isError = true;
        }
    }


}
