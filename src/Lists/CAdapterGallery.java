package Lists;

import java.io.File;
import java.util.List;

import Constantes.ConstantesEntities;
import Entities.CItemGallery;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jarvis.R;

public class CAdapterGallery extends ArrayAdapter<CItemGallery> {

	public  CAdapterGallery(Context context, int textViewResourceId, List<CItemGallery> data){
		super(context, textViewResourceId, data);
	}
   
	@Override
	public View getView (int position, View convertView, ViewGroup parent) {
		View v = convertView;

		/*********** Si l'image existe on la met sinon, image par défaut **********************/
		ImageView imgViewItem = new ImageView(getContext());
		TextView textViewItem = new TextView(getContext());
		
		
		if(position < this.getCount()) {
			CItemGallery oItem = this.getItem(position);
			if (oItem != null) {
				imgViewItem = (ImageView)v.findViewById(R.id.imageViewItem);
				if (imgViewItem != null) {
					File ftest = new File(Environment.getExternalStorageDirectory() +
							File.separator + ConstantesEntities.PATH_REP_IMG +"/" + oItem.getMsImagePath());
					if (ftest.exists()){
						BitmapDrawable bm = new BitmapDrawable(oItem.getMoResource(), Environment.getExternalStorageDirectory() + File.separator + ConstantesEntities.PATH_REP_IMG + "/" + oItem.getMsLibelle());
						imgViewItem.setBackground(bm);
					}
					else{
						imgViewItem.setBackgroundResource(R.drawable.ic_launcher);
					}
				}
			}
				
			textViewItem = (TextView)v.findViewById(R.id.textViewItem);
			if (textViewItem != null){
				textViewItem.setText(oItem.getMsLibelle());                           
			}
		}
        return v;
	}
}