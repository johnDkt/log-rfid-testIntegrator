package com.company.testIntegrator.scenario;

/**
 * Created by Jonathan on 29/03/2019.
 */

public class ConnectDevice {

    /**
     * use to connect to a device.
     * will use information on application.properties to connect on.
     */
    public static void connectDevice() {
        try {
            /*RFIDConnectConnectorFactoryList.getInstance().sendCommand(
                    ConnectCommandToSend.createCommand(CommandManager.COMMAND_ACTION.CONNECT_DEVICE)
            );*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
