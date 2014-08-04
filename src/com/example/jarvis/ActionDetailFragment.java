package com.example.jarvis;

import java.util.ArrayList;
import java.util.List;

import Lists.Detail;
import Lists.DetailAdapter;
import Lists.GalleryAdapter;
import Lists.GalleryItem;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.jarvis.dummy.DummyContent;

/**
 * A fragment representing a single Action detail screen.
 * This fragment is either contained in a {@link ActionListActivity}
 * in two-pane mode (on tablets) or a {@link ActionDetailActivity}
 * on handsets.
 */
public class ActionDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private DummyContent.DummyItem mItem;

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
            mItem = DummyContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	Log.i("LIST", "oncreateview");
        View rootView = inflater.inflate(R.layout.fragment_action_detail, container, false);
//        return inflater.inflate(R.layout.layout_gallery, container, false);
        // Show the dummy content as text in a TextView.
        if (mItem != null) {
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
        }
        return rootView;
    }
}
