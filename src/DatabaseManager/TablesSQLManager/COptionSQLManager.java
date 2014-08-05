package DatabaseManager.TablesSQLManager;

import DatabaseManager.CConstantesSQL;
import DatabaseManager.CGenericDatabaseManager;
import Entities.Option;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class COptionSQLManager extends CGenericDatabaseManager{

	public COptionSQLManager(Context context) {
		super(context);
	}

	public static long insert(Option poOption){
		ContentValues values = new ContentValues();
		values.put(CConstantesSQL.OPTION_ID, poOption.getId());
		values.put(CConstantesSQL.OPTION_LIB, poOption.getMsLibelle());
		return bdd.insert(CConstantesSQL.TABLE_OPTION, null, values);
	}
	
	/**
	 * 
	 * @param poOption
	 */
	public void update(Option poOption){
		Cursor c = bdd.query(poOption.getMsAssociatedTable(), 
				new String[] {CConstantesSQL.OPTION_ID, 
			CConstantesSQL.OPTION_LIB}, 
				CConstantesSQL.OPTION_ID + " = " + poOption.getMiId(), null, null, null, null);

		c.moveToFirst();
		ContentValues newValues = new ContentValues();
		newValues.put(CConstantesSQL.OPTION_LIB, poOption.getMsLibelle());

		bdd.update(poOption.getMsAssociatedTable(), newValues, CConstantesSQL.OPTION_ID + " = " + poOption.getMiId(), null);

		c.close();
	}
}
