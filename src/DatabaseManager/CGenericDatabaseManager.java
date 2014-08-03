package DatabaseManager;

import Entities.Entity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class CGenericDatabaseManager {

	protected static final int VERSION_BDD = 0;
	protected static final String BDD_NAME = "jarvis.db";
	protected static SQLiteDatabase bdd;
	protected CGenericDatabaseCreate SQLiteBase ;

	public CGenericDatabaseManager(Context context){
		SQLiteBase = new CGenericDatabaseCreate(context, BDD_NAME, null, VERSION_BDD);
	}

	public void open(){
		bdd = SQLiteBase.getWritableDatabase();

	}

	public void close(){
		bdd.close();
	}
	
	public SQLiteDatabase getBDD(){
		return bdd;
	}
	
	public int delete(Entity oEntity){
		return bdd.delete(oEntity.getMsAssociatedTable(), "id="+oEntity.getMiId(), null);
	}

}
