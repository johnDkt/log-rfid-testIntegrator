package com.company.testIntegrator;

import com.company.testIntegrator.scenario.FirstTestObserverObservable;

public class Main {


    public static void main(String[] args)  {
           new FirstTestObserverObservable().startScenario();
/*
        RFIDConnectJavaMqttInstance instance = null;
        try {
           instance  = CJI.getInstance(ConnectCmdKey.DEFAULT_LISTENER);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CJI.setDEFAULT_TYPE_INSTANCE(ConnectCmdKey.OBSERVABLE_PATTERN);

        if(ConnectCmdKey.OBSERVABLE_PATTERN.equals(CJI.getInstanceType())){
            instance.setClassThatComputeReceivedCommands(new ConnectCommandObservable());
        }else if(ConnectCmdKey.LISTENER_PATTERN.equals(CJI.getInstanceType())){
            instance.setClassThatComputeReceivedCommands(new ConnectCommandToReceiveList("id",new DefaultPropagatorListener()));
            CJIListenerFactory.removeDefaultListener();
            try {
                CJIListenerFactory.registerNewListener("id1",new DefaultPropagatorListener());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        RFIDConnectJavaMqttInstance instance = new CJIFluentConfigurator(ConnectCmdKey.LISTENER_PATTERN,"127.0.0.1","55555",new LoggerImpl())
                .removeDefautlListener()
                .addListener("ROGER-le-listener",new CustomPropagator())
                .addListener("ROGER-le-retour", new CustomPropagator2())
                .returnInstance();

        instance.sendCommand(ConnectCommandToSend.createCommand(
                CommandManager.COMMAND_ACTION.CONNECT_DEVICE,
                new Optionals()
                        .put("secure", false)
                        .put("businessProcess", "toto")
                        .build()
        ));
        */
    }
}
