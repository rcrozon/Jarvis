package Transfers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.util.Log;

import Serialization.Serializor;

public class Client extends Transfers {

	private Socket client;
	private FileInputStream fileInputStream;
	private BufferedInputStream bufferedInputStream;
	private OutputStream outputStream;
	
	public Client(){}

	@Override
	public void sendSerializedObject(Object poObjectToSend) throws IOException {
		Log.i("SEND", "Passe");
//		File file = new File("/mnt/sdcard/input.txt"); //create file instance
		File file = Serializor.serialize(poObjectToSend);
	    try {
	      
	    	Socket client = new Socket(sIpAddress, iPort);

			Log.i("SEND", "Passe2");
	    	byte[] mybytearray = new byte[(int) file.length()]; //create a byte array to file
	 
		    fileInputStream = new FileInputStream(file);
		    bufferedInputStream = new BufferedInputStream(fileInputStream);  
		    bufferedInputStream.read(mybytearray, 0, mybytearray.length); //read the file
		    outputStream = client.getOutputStream();

			Log.i("SEND", "Passe3");
		    outputStream.write(mybytearray, 0, mybytearray.length); //write file to the output stream byte by byte
		    outputStream.flush();
		    bufferedInputStream.close();
		    outputStream.close();
		    client.close();
		    Log.i("SEND", "Passe4");
	    } catch (UnknownHostException e) {
	    	Log.e("SERCLIENT", "unknowHost " + e.getMessage());
	    } catch (IOException e) {
	    	Log.e("SERCLIENT", "io " + e.getMessage());
	    }
	}
}
