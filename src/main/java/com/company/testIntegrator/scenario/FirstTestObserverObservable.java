package com.company.testIntegrator.scenario;

import com.company.testIntegrator.utils.LoggerImpl;
import com.decathlon.connectJavaIntegrator.configurator.CJIFluentConfigurator;
import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.CommandManager;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.commandsObject.optionals.Optionals;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.receiveFromConnectJava.observable.EventPropagatorObject;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.sendToConnectJava.ConnectCommandToSend;
import com.decathlon.connectJavaIntegrator.utils.ConnectCmdKey;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.TimerTask;

/**
 * Created by Jonathan on 12/08/2019.
 */
public class FirstTestObserverObservable implements Observer  {

    private static Logger LOGGER = Logger.getLogger(FirstTestObserverObservable.class);

     RFIDConnectJavaMqttInstance RFIDConnectInstance;

    public FirstTestObserverObservable(){
        this.RFIDConnectInstance =  new CJIFluentConfigurator(ConnectCmdKey.OBSERVABLE_PATTERN,new LoggerImpl()).addObserver(this).returnInstance();
    }

    public void startScenario(){
        RFIDConnectInstance.sendCommand(
                ConnectCommandToSend.createCommand(
                        CommandManager.COMMAND_ACTION.CONNECT_DEVICE,
                        new Optionals().put(CommandManager.COMMAND_EXTRA.COUNTRY, "FR")
                                .put(CommandManager.COMMAND_EXTRA.BUSINESS_PROCESS,"Picking")
                                .build()
                ));
    }

    public void startRead(){
        RFIDConnectInstance.sendCommand(ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.START_CONTINUOUS_READ));
        stopIn5s();
    }

    public void stopIn5s(){
            LOGGER.info("stop in 5s armed");
            java.util.Timer disconnectionTimer = new java.util.Timer("stopRead-timer");
            disconnectionTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    LOGGER.info("stop read");
                    try {
                        RFIDConnectInstance.sendCommand(ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.STOP_READ));
                        //close();
                    } catch (Exception e) {
                        LOGGER.error(e);
                    }
                }
            }, 5000);
    }


    public void close(){
        java.util.Timer disconnectionTimer = new java.util.Timer("exit-timer");
        disconnectionTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("exit");
                try {
                    RFIDConnectInstance.close();
                } catch (IOException e) {
                    LOGGER.error(e);
                }
            }
        },10);
    }


    public void update(Observable o, Object arg) {

        System.out.println("update call");
        EventPropagatorObject event = (EventPropagatorObject) arg;
        LOGGER.info(event.toString());
        if(ConnectCmdKey.ACTION_CONNECT.equals(event.getTitleEvent())){
            if(event.getFunctionnalSucces()){
                LOGGER.info("connect success");
                LOGGER.info("start read");
                startRead();
            }else if(event.getFunctionnalDataContainer().get("STATUS").equals("202")){
                RFIDConnectInstance.sendCommand(ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.DISCONNECT_DEVICE));
            }
        }

        if(ConnectCmdKey.ACTION_START.equals(event.getTitleEvent())){
            if(event.getFunctionnalSucces()){
                System.out.println(event.getFunctionnalDataContainer().get("TAG"));
            }
        }

        if(ConnectCmdKey.ACTION_STOP.equals(event.getTitleEvent())){
            RFIDConnectInstance.sendCommand(ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.DISCONNECT_DEVICE));
        }

        if(ConnectCmdKey.ACTION_DISCONNECT.equals(event.getTitleEvent())){
            close();
            System.exit(0);
        }
    }
}
