package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import android.util.Log;

import Entries.Entry;

public abstract class Serializor {

	public static File serialize(Object poSerializableObject) {
		File file =  new File("/mnt/sdcard/input.txt");

		 // ouverture d'un flux sur un fichier
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(file));
		
		
			// sérialization de l'objet
			oos.writeObject(poSerializableObject) ;
		} catch (FileNotFoundException e) {
	    	Log.e("SERIALIZ", "filenotfound " + e.getMessage());
		} catch (IOException e) {
	    	Log.e("SERIALIZ", "io " + e.getMessage());
		}return file;
	}
	
	public static Object unserialize(File fFile) throws FileNotFoundException, IOException{
		 // ouverture d'un flux sur un fichier
		ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fFile)) ;
		 // désérialization de l'objet
		Entry oEntry = null;
		try {
			oEntry = (Entry)ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return oEntry;
	}

}
