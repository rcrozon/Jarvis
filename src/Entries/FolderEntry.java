package Entries;

import java.io.File;
import java.util.Vector;

public class FolderEntry extends Entry{

	private Vector<Entry> 	mvEntries;
	private String 			msPath;
	
	public FolderEntry(String psPath){
		super(psPath);
		msPath = psPath;
		
	}
}
