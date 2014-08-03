package DatabaseManager;

import Entities.Device;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class CDeviceSQLManager extends CGenericDatabaseManager{

	public CDeviceSQLManager(Context context) {
		super(context);
	}

	public static long insert(Device oDevice){
		ContentValues values = new ContentValues();
		values.put(CConstantesSQL.DEVICE_ID, oDevice.getMiId());
		values.put(CConstantesSQL.DEVICE_LIB, oDevice.getMsLibelle());
		values.put(CConstantesSQL.DEVICE_DESCRI, oDevice.getMsDescription());
		return bdd.insert(CConstantesSQL.DEVICE_TABLE, null, values);
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
