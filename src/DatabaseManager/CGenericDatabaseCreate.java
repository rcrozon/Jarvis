package DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CGenericDatabaseCreate extends SQLiteOpenHelper {

	private static final String CREATE_BDD_DEVICE = "CREATE TABLE IF NOT EXISTS " + CConstantesSQL.TABLE_DEVICE
			+ " ("+ CConstantesSQL.DEVICE_ID + " INTEGER PRIMARY KEY, " 
			+ CConstantesSQL.DEVICE_LIB + " TEXT NOT NULL, "
			+ CConstantesSQL.DEVICE_DESCRI + " TEXT);";
	
	private static final String CREATE_BDD_OPTION = "CREATE TABLE IF NOT EXISTS " + CConstantesSQL.TABLE_OPTION
			+ " ("+ CConstantesSQL.OPTION_ID + " INTEGER PRIMARY KEY, " 
			+ CConstantesSQL.OPTION_LIB + " TEXT NOT NULL);";
	 
	
	public CGenericDatabaseCreate(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BDD_DEVICE);
		db.execSQL(CREATE_BDD_OPTION);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + CConstantesSQL.TABLE_DEVICE + ";");
		db.execSQL("DROP TABLE IF EXISTS " + CConstantesSQL.TABLE_OPTION + ";");
		onCreate(db);
	}
}
