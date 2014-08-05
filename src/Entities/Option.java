package Entities;

import java.util.ArrayList;
import java.util.List;

import Constantes.ConstantesEntities;

public class Option extends Entity{

	public static List<Option> options;
	
	public Option(int piId, String psLibelle){
		this.msLibelle = psLibelle;
		this.miId = piId;
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
		return miId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.miId = id;
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

	public static List<Option> getOptionsList(){
		if (options == null){
			options = new ArrayList<Option>();
			for(int i = 0; i < ConstantesEntities.LIST_LABELS_OPTIONS.length; i++){
				options.add(new Option(i+1, ConstantesEntities.LIST_LABELS_OPTIONS[i] )); 
			}
		}else{
			return options;
		}
		return options;
	}
}
