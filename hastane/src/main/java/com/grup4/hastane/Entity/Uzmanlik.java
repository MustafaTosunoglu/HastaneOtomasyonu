package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uzmanlik implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer uzmanlikId;

	private String uzmanlikAdi;

	public Uzmanlik() {
	}

	public Uzmanlik(int uzmanlikId, String uzmanlikAdi) {
		super();
		this.uzmanlikId = uzmanlikId;
		this.uzmanlikAdi = uzmanlikAdi;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getUzmanlikId() {
		return uzmanlikId;
	}	

	public void setUzmanlikId(Integer uzmanlikId) {
		this.uzmanlikId = uzmanlikId;
	}

	public String getUzmanlikAdi() {
		return uzmanlikAdi;
	}

	public void setUzmanlikAdi(String uzmanlikAdi) {
		this.uzmanlikAdi = uzmanlikAdi;
	}
	@Override
	public int hashCode() {
		return this.getUzmanlikId().hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Uzmanlik) {
			Uzmanlik oObj = (Uzmanlik) obj;
			if (this.getUzmanlikId().equals(oObj.getUzmanlikId())) {
				equal = true;
			}
		}
		return equal;
	}
}

