package Lists;

public class GalleryItem {

	private String msLibelle ;
	private int id;
	
	public GalleryItem(int id, String psLibelle){
		this.msLibelle = psLibelle;
		this.id = id;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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

}
