package com.grup4.hastane.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.grup4.hastane.Entity.Kullanici;


@Entity
public class Kullanici implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer kullaniciId;
	private String kullaniciYetki;
	private String kullaniciAdi;
	private String kullaniciSifre;
	private String kullaniciMail;
	
	public Kullanici() {
		
	}

	public Kullanici(Integer kullaniciId, String kullaniciAdi, String kullaniciYetki, String kullaniciSifre, String kullaniciMail) {
		super();
		this.kullaniciId = kullaniciId;
		this.kullaniciAdi = kullaniciAdi;
		this.kullaniciYetki = kullaniciYetki;
		this.kullaniciSifre = kullaniciSifre;
		this.kullaniciMail = kullaniciMail;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean equal = false;
		if (obj != null && obj instanceof Kullanici) {
			Kullanici oObj = (Kullanici) obj;
			if (this.getKullaniciId().equals(oObj.getKullaniciId())) {
				equal = true;
			}
		}
		return equal;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}
	
	@Override
	public int hashCode() {
		return this.getKullaniciId().hashCode();
	}

	public String getKullaniciYetki() {
		return kullaniciYetki;
	}

	public void setKullaniciYetki(String kullaniciYetki) {
		this.kullaniciYetki = kullaniciYetki;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getKullaniciSifre() {
		return kullaniciSifre;
	}

	public void setKullaniciSifre(String kullaniciSifre) {
		this.kullaniciSifre = kullaniciSifre;
	}

	public String getKullaniciMail() {
		return kullaniciMail;
	}

	public void setKullaniciMail(String kullaniciMail) {
		this.kullaniciMail = kullaniciMail;
	}

	

}
