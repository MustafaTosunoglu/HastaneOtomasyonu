package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class DoktorUzmanlik implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 953834944793489167L;
	
	private String pk;
	private Doktor doktor;
	private Uzmanlik uzmanlik;
	
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
	
	@JoinColumn(name = "uzmanlikId")
	@ManyToOne(targetEntity=Uzmanlik.class)
	public Uzmanlik getUzmanlik() {
		return uzmanlik;
	}

	public void setUzmanlik(Uzmanlik uzmanlik) {
		this.uzmanlik = uzmanlik;
		checkPk();
	}
	
	public static String getPkString(Doktor doktor, Uzmanlik uzmanlik){
		return doktor.getDoktorId()+ "-" +uzmanlik.getUzmanlikId();
	}
	
	private void checkPk() {
		if (this.doktor != null && this.uzmanlik != null) {
			this.pk = getPkString(this.doktor, this.uzmanlik);
		}
	}
	
	@Override
	public int hashCode() {
		return this.getPk().hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof DoktorUzmanlik) {
			DoktorUzmanlik oObj = (DoktorUzmanlik) obj;
			if (this.getPk().equals(oObj.getPk())) {
				equal = true;
			}
		}
		return equal;
	}

}
