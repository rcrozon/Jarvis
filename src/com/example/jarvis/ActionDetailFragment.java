package com.example.jarvis;

import java.util.ArrayList;
import java.util.List;

import Entities.Detail;
import Lists.DetailAdapter;
import Lists.GalleryAdapter;
import Lists.GalleryItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * A fragment representing a single Action detail screen.
 * This fragment is either contained in a {@link ActionListActivity}
 * in two-pane mode (on tablets) or a {@link ActionDetailActivity}
 * on handsets.
 */
public class ActionDetailFragment extends Fragment implements OnClickListener {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

	private Button btnSendToPC;
	private Button btnSendToTV;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ActionDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.i("LIST", "oncreateview");
        View rootView = inflater.inflate(R.layout.fragment_action_detail, container, false);
//        return inflater.inflate(R.layout.layout_gallery, container, false);
        // Show the dummy content as text in a TextView.

		btnSendToPC = (Button) rootView.findViewById(R.id.buttonPCItem);
		btnSendToTV = (Button) rootView.findViewById(R.id.buttonTVItem);
		btnSendToPC.setOnClickListener(this);
		btnSendToTV.setOnClickListener(this);
    	GridView vwGrid = (GridView) rootView.findViewById(R.id.gridView);
    	LinearLayout linearLayout = (LinearLayout)rootView.findViewById(R.id.linearLayout);
    	if (linearLayout != null){
    		ListView vwItems = (ListView) linearLayout.findViewById(R.id.listViewFiles);
        	if (vwItems != null){
        		List<Detail> lItems = new ArrayList<Detail>();
        		lItems.add(new Detail(1, "file 1"));
        		lItems.add(new Detail(2, "file 2"));
        		lItems.add(new Detail(3, "file 3"));
        		lItems.add(new Detail(4, "file 4"));
        		vwItems.setAdapter(new DetailAdapter(this.getActivity(), R.layout.detail, lItems));
    		}else{
        		Log.i("LIST", "list null");
        	}
    	}else{
    		Log.i("LIST", "layout  null");
    	}
    	if (vwGrid != null){
    		Log.i("LIST", "grid pas null");
    		List<GalleryItem> lGalleryItems = new ArrayList<GalleryItem>();
    		lGalleryItems.add(new GalleryItem(1, "AAAA"));
    		lGalleryItems.add(new GalleryItem(2, "BBBB"));
    		lGalleryItems.add(new GalleryItem(3, "CCCC"));
    		lGalleryItems.add(new GalleryItem(4, "DDDD"));
    		lGalleryItems.add(new GalleryItem(5, "EEEE"));
    		vwGrid.setAdapter(new GalleryAdapter(this.getActivity(), R.layout.gallery_item, lGalleryItems));
    	}else{
    		Log.i("LIST", "grid null");
    	}
        return rootView;
    }

	@Override
	public void onClick(View v) {
		Log.i("CLICK", "passe");
		if (v == btnSendToPC) {
			btnSendToPC.setBackgroundResource(R.drawable.send_to_pc_selected);
			btnSendToTV.setBackgroundResource(R.drawable.send_to_tv);
		} else {
			btnSendToTV.setBackgroundResource(R.drawable.send_to_tv_selected);
			btnSendToPC.setBackgroundResource(R.drawable.send_to_pc);
		}
	}

}
