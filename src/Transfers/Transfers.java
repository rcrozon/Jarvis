package Transfers;

import java.io.IOException;

public abstract class Transfers {

	protected String sIpAddress = "192.168.0.12";
	protected int iPort = 8090;
	
	public abstract void sendSerializedObject(Object oObjectToSend) throws IOException ;
}
