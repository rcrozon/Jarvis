package DatabaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class CGenericDatabaseCreate extends SQLiteOpenHelper {
	
	private static final String CREATE_BDD_DEVICE = "CREATE TABLE IF NOT EXISTS " + CConstantesSQL.DEVICE_TABLE 
			+ " ("+ CConstantesSQL.DEVICE_ID + " INTEGER PRIMARY KEY, " 
			+ CConstantesSQL.DEVICE_LIB + " TEXT NOT NULL, "
			+ CConstantesSQL.DEVICE_DESCRI + " TEXT);";
	 
	public CGenericDatabaseCreate(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_BDD_DEVICE);
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + CConstantesSQL.DEVICE_TABLE + ";");
		onCreate(db);
	}
}
