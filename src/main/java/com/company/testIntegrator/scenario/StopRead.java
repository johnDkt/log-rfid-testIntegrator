package com.company.testIntegrator.scenario;

import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.CommandManager;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.sendToConnectJava.ConnectCommandToSend;

/**
 * Created by Jonathan on 29/03/2019.
 */
public class StopRead {

    public StopRead(RFIDConnectJavaMqttInstance connectInstance) {
        connectInstance.sendCommand(
                ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.STOP_READ)
        );
    }
}
