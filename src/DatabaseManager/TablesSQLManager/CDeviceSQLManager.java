package DatabaseManager.TablesSQLManager;

import DatabaseManager.CConstantesSQL;
import DatabaseManager.CGenericDatabaseManager;
import Entities.Device;
import Entities.Option;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CDeviceSQLManager extends CGenericDatabaseManager{

	public CDeviceSQLManager(Context context) {
		super(context);
	}

	public static long insert(Device poDevice){
		ContentValues values = new ContentValues();
		values.put(CConstantesSQL.DEVICE_ID, poDevice.getMiId());
		values.put(CConstantesSQL.DEVICE_LIB, poDevice.getMsLibelle());
		values.put(CConstantesSQL.DEVICE_DESCRI, poDevice.getMsDescription());
		return bdd.insert(CConstantesSQL.TABLE_DEVICE, null, values);
	}
	
	/**
	 * 
	 * @param oDevice
	 */
	public void update(Device oDevice){
		Cursor c = bdd.query(oDevice.getMsAssociatedTable(), 
				new String[] {CConstantesSQL.DEVICE_ID, 
			CConstantesSQL.DEVICE_LIB, 
			CConstantesSQL.DEVICE_DESCRI}, 
				CConstantesSQL.DEVICE_ID + " = " + oDevice.getMiId(), null, null, null, null);

		c.moveToFirst();
		ContentValues newValues = new ContentValues();
		newValues.put(CConstantesSQL.DEVICE_LIB, oDevice.getMsLibelle());
		newValues.put(CConstantesSQL.DEVICE_DESCRI, oDevice.getMsDescription());

		bdd.update(oDevice.getMsAssociatedTable(), newValues, CConstantesSQL.DEVICE_ID + " = " + oDevice.getMiId(), null);

		c.close();
	}
}
