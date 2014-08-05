package Lists;

import java.util.List;

import Entities.Detail;
import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.jarvis.R;


public class DetailAdapter extends ArrayAdapter<Detail> {

	Context moContext;
	
	public DetailAdapter(Context context, int textViewResourceId, List<Detail> data) {
		super(context, textViewResourceId, data);
		this.moContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) moContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.detail, null);
		}
		if (position < this.getCount()) {
			Detail oDetail = this.getItem(position);
			if (oDetail != null) {

				TextView vwLibelle = (TextView) v.findViewById(R.id.txtItemLibelle);
				if (vwLibelle != null) {
					vwLibelle.setText(oDetail.getMsLibelle());
				}
			}
		}
//		LayoutParams lp = new LayoutParams(100, 50);
//		v.setLayoutParams(lp);
		return v;
	}
}
