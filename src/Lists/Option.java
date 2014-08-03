package Lists;

public class Option {

	private String msLibelle ;
	
	public Option(String psLibelle){
		this.msLibelle = psLibelle;
	}
	
	public String toString(){
		return msLibelle;
	}
	
	public String getMsLibelle(){
		return msLibelle;
	}
	
	public void setMsLibelle(String psLibelle){
		this.msLibelle = psLibelle;
	}

}
