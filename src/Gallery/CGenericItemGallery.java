package Gallery;

import java.io.File;

import Constantes.ConstantesEntities;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Environment;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jarvis.R;

public class CGenericItemGallery extends FrameLayout{

	ImageView imgView  ;
	TextView  textView ;
	
	public CGenericItemGallery(Context context) {
		super(context);

		this.imgView  = new ImageView(context);
		this.textView = new TextView(context);
		this.addView(imgView);
		this.addView(textView);
	}

	public void setContent(String sImgPath, String sLibelle){

		/*********** Si l'image existe on la met sinon, image par défaut **********************/
		File ftest = new File(Environment.getExternalStorageDirectory() +
				File.separator + ConstantesEntities.PATH_REP_IMG +"/" + sImgPath);
		if (ftest.exists()){
			BitmapDrawable bm = new BitmapDrawable(getResources(), Environment.getExternalStorageDirectory() +
					File.separator +  ConstantesEntities.PATH_REP_IMG+"/" + sImgPath);
			imgView.setBackground(bm);
		}
		else{
			imgView.setBackgroundResource(R.drawable.ic_launcher);
		}
		
		textView.setText(sLibelle);
	}
}
