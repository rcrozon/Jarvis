package Lists;

import java.util.List;

import com.example.jarvis.R;

import Entities.Option;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
				ImageView vwImg	= (ImageView)v.findViewById(R.id.imageViewOption);
				if(vwImg != null){
					switch(oOption.getId()){
						case 1 : vwImg.setBackgroundResource(R.drawable.video);break;
						case 2 : vwImg.setBackgroundResource(R.drawable.musique);break;
						case 3 : vwImg.setBackgroundResource(R.drawable.video);break;
						default : vwImg.setBackgroundResource(R.drawable.ic_launcher);
					}
				}
			}
		}
		return v;
	}
}
