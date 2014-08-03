package Lists;

public class Option {

	private String msLibelle ;
	private int id;
	
	public Option(int id, String psLibelle){
		this.msLibelle = psLibelle;
		this.id = id;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return msLibelle;
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
	 * 
	 * @return
	 */
	public String getMsLibelle(){
		return msLibelle;
	}
	
	/**
	 * 
	 * @param psLibelle
	 */
	public void setMsLibelle(String psLibelle){
		this.msLibelle = psLibelle;
	}

}
