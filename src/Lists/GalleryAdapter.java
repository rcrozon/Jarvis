package Lists;

import java.io.File;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jarvis.R;

public class GalleryAdapter extends ArrayAdapter<GalleryItem> {

	Context moContext;

	public GalleryAdapter(Context context, int textViewResourceId,
			List<GalleryItem> data) {
		super(context, textViewResourceId, data);
		this.moContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) moContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;
		if (convertView == null) {
			GalleryItem oItem = this.getItem(position);
			Log.i("LIST", "pas null " + oItem.getMsLibelle()); 
			gridView = new View(moContext);
			gridView = inflater.inflate(R.layout.gallery_item, null);
			ImageView imageView = (ImageView) gridView.findViewById(R.id.imageViewItem);
			imageView.setBackgroundResource(R.drawable.video);
			TextView textView = (TextView) gridView.findViewById(R.id.textViewItem);
			textView.setText(oItem.getMsLibelle());
		} else {
			Log.i("LIST", "null");
			gridView = (View) convertView;
		}
		return gridView;

	}
}
