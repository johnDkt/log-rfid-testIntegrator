package com.company.testIntegrator.scenario;

import com.decathlon.connectJavaIntegrator.mqtt.RFIDConnectJavaMqttInstance;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.CommandManager;
import com.decathlon.connectJavaIntegrator.mqtt.handleCommands.sendToConnectJava.ConnectCommandToSend;


/**
 * Created by Jonathan on 29/03/2019.
 */
public class DisconnectDevice {

    public DisconnectDevice(RFIDConnectJavaMqttInstance connectInstance) {
        connectInstance.sendCommand(
                ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.DISCONNECT_DEVICE)
        );
    }

}
