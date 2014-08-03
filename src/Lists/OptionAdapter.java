package Lists;

import java.util.List;

import com.example.jarvis.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class OptionAdapter extends ArrayAdapter<Option> {

	Context moContext;
	
	public OptionAdapter(Context context, int textViewResourceId, List<Option> data) {
		super(context, textViewResourceId, data);
		this.moContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) moContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.option, null);
		}
		if (position < this.getCount()) {
			Option oOption = this.getItem(position);
			if (oOption != null) {

				TextView vwLibelle = (TextView) v.findViewById(R.id.txtLibelle);
				if (vwLibelle != null) {
					vwLibelle.setText(oOption.getMsLibelle());
				}
			}
		}
		return v;
	}
}
