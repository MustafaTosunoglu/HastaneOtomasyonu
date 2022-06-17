package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.grup4.hastane.Entity.Hasta;


@Entity
public class Hasta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer hastaId;
	private String hastaTC;
	private String hastaAdi;
	private String hastaSoyadi;
	private String hastaCinsiyet;
	private String hastaTel;
	private String hastaDogumTarihi;
	
	public Hasta() {
		
	}

	public Hasta(Integer hastaId, String hastaTC, String hastaAdi, String hastaSoyadi, String hastaCinsiyet, String hastaTel, String hastaDogumTarihi) {
		super();
		this.hastaId = hastaId;
		this.hastaTC = hastaTC;
		this.hastaAdi = hastaAdi;
		this.hastaSoyadi = hastaSoyadi;
		this.hastaCinsiyet = hastaCinsiyet;
		this.hastaTel = hastaTel;
		this.hastaDogumTarihi = hastaDogumTarihi;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Hasta) {
			Hasta oObj = (Hasta) obj;
			if (this.getHastaId().equals(oObj.getHastaId())) {
				equal = true;
			}
		}
		return equal;
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getHastaId() {
		return hastaId;
	}

	public void setHastaId(Integer hastaId) {
		this.hastaId = hastaId;
	}

	public String getHastaTC() {
		return hastaTC;
	}

	public void setHastaTC(String hastaTC) {
		this.hastaTC = hastaTC;
	}

	public String getHastaAdi() {
		return hastaAdi;
	}

	public void setHastaAdi(String hastaAdi) {
		this.hastaAdi = hastaAdi;
	}

	public String getHastaSoyadi() {
		return hastaSoyadi;
	}

	public void setHastaSoyadi(String hastaSoyadi) {
		this.hastaSoyadi = hastaSoyadi;
	}

	public String getHastaCinsiyet() {
		return hastaCinsiyet;
	}

	public void setHastaCinsiyet(String hastaCinsiyet) {
		this.hastaCinsiyet = hastaCinsiyet;
	}

	public String getHastaTel() {
		return hastaTel;
	}

	public void setHastaTel(String hastaTel) {
		this.hastaTel = hastaTel;
	}

	public String getHastaDogumTarihi() {
		return hastaDogumTarihi;
	}

	public void setHastaDogumTarihi(String hastaDogumTarihi) {
		this.hastaDogumTarihi = hastaDogumTarihi;
	}

	@Override
	public int hashCode() {
		return this.getHastaId().hashCode();
	}


	

}
