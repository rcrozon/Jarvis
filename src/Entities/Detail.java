package Entities;

public class Detail extends Entity{

	
	public Detail(int miId, String psLibelle){
		this.msLibelle = psLibelle;
		this.miId = miId;
	}
	
	/**
	 * @return the miId
	 */
	public int getmiId() {
		return miId;
	}

	/**
	 * @param miId the miId to set
	 */
	public void setmiId(int miId) {
		this.miId = miId;
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
