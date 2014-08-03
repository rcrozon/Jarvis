package Entities;

import Gallery.CGenericItemGallery;
import android.content.Context;
import android.content.res.Resources;

public class CItemGallery extends CGenericItemGallery {

	private Resources moResource ;
	private String msLibelle ;
	private String msImagePath;
	
	public CItemGallery(Context context, String psLibelle) {
		super(context);
		msLibelle = psLibelle;
	}

	/**
	 * @return the moResource
	 */
	public Resources getMoResource() {
		return moResource;
	}

	/**
	 * @param moResource the moResource to set
	 */
	public void setMoResource(Resources poResource) {
		this.moResource = poResource;
	}

	/**
	 * @return the msLibelle
	 */
	public String getMsLibelle() {
		return msLibelle;
	}

	/**
	 * @param msLibelle the msLibelle to set
	 */
	public void setMsLibelle(String msLibelle) {
		this.msLibelle = msLibelle;
	}

	/**
	 * @return the msImagePath
	 */
	public String getMsImagePath() {
		return msImagePath;
	}

	/**
	 * @param msImagePath the msImagePath to set
	 */
	public void setMsImagePath(String msImagePath) {
		this.msImagePath = msImagePath;
	}

	
}
