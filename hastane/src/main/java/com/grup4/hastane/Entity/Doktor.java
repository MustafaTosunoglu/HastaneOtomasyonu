package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doktor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer doktorId;
	private String doktorAdi;
	private String doktorSoyadi;
	private String doktorSifre;
	private String doktorMail;
	private String doktorKayitTarihi;
	
	public Doktor() {
	}

	public Doktor(Integer doktorId, String doktorAdi, String doktorSoyadi, String doktorSifre, String doktorMail, String doktorKayitTarihi) {
		super();
		this.doktorId = doktorId;
		this.doktorAdi = doktorAdi;
		this.doktorSoyadi = doktorSoyadi;
		this.doktorSifre = doktorSifre;
		this.doktorMail = doktorMail;
		this.doktorKayitTarihi = doktorKayitTarihi;
	}
	

	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Doktor) {
			Doktor oObj = (Doktor) obj;
			if (this.getDoktorId().equals(oObj.getDoktorId())) {
				equal = true;
			}
		}
		return equal;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getDoktorId() {
		return doktorId;
	}

	public void setDoktorId(Integer doktorId) {
		this.doktorId = doktorId;
	}

	public String getDoktorAdi() {
		return doktorAdi;
	}

	public void setDoktorAdi(String doktorAdi) {
		this.doktorAdi = doktorAdi;
	}

	public String getDoktorSoyadi() {
		return doktorSoyadi;
	}

	public void setDoktorSoyadi(String doktorSoyadi) {
		this.doktorSoyadi = doktorSoyadi;
	}

	public String getDoktorSifre() {
		return doktorSifre;
	}

	public void setDoktorSifre(String doktorSifre) {
		this.doktorSifre = doktorSifre;
	}

	public String getDoktorMail() {
		return doktorMail;
	}

	public void setDoktorMail(String doktorMail) {
		this.doktorMail = doktorMail;
	}

	@Override
	public int hashCode() {
		return this.getDoktorId().hashCode();
	}

	public String getDoktorKayitTarihi() {
		return doktorKayitTarihi;
	}

	public void setDoktorKayitTarihi(String doktorKayitTarihi) {
		this.doktorKayitTarihi = doktorKayitTarihi;
	}

}
