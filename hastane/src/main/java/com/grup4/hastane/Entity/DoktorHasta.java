package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class DoktorHasta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953834944793489167L;
	
	private String pk;
	private Doktor doktor;
	private Hasta hasta;
	
	@Id
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}
	
	@JoinColumn(name = "doktorId")
	@ManyToOne(targetEntity=Doktor.class)
	public Doktor getDoktor() {
		return doktor;
	}

	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
		checkPk();
	}
	
	@JoinColumn(name = "hastaId")
	@ManyToOne(targetEntity=Hasta.class)
	public Hasta getHasta() {
		return hasta;
	}

	public void setHasta(Hasta hasta) {
		this.hasta = hasta;
		checkPk();
	}

	public static String getPkString(Doktor doktor, Hasta hasta){
		return doktor.getDoktorId()+ "-" +hasta.getHastaId();
	}
	
	private void checkPk() {
		if (this.doktor != null && this.hasta != null) {
			this.pk = getPkString(this.doktor, this.hasta);
		}
	}
	
	@Override
	public int hashCode() {
		return this.getPk().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof DoktorHasta) {
			DoktorHasta oObj = (DoktorHasta) obj;
			if (this.getPk().equals(oObj.getPk())) {
				equal = true;
			}
		}
		return equal;
	}

}
