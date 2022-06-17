package com.grup4.hastane.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import com.grup4.hastane.Controller.KullaniciController;
import com.grup4.hastane.Entity.Kullanici;

@RequestScope
@Named(KullaniciEkleBean.BEAN_NAME)
public class KullaniciEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String BEAN_NAME = "kullaniciEkleBean";

	private String kullaniciAdi;
	private String kullaniciSifre;
	private String kullaniciMail;
	private String kullaniciYetki;
	
	private List<Kullanici> kullanicilar;
	private Integer kullaniciId;

	@Autowired
	private KullaniciController ks;

	public void kullaniciEkle() {

		this.ks.kullaniciEkle(this.kullaniciAdi, this.kullaniciSifre, this.kullaniciMail, this.kullaniciYetki);
		showInfo();

		this.kullaniciAdi = null;
		this.kullaniciSifre = null;
		this.kullaniciMail = null;
		this.kullaniciYetki = null;
	}
	
	public void kullaniciGuncelle(Kullanici k) {
		this.ks.kullaniciGuncelle(k.getKullaniciId(), k.getKullaniciAdi(), k.getKullaniciSifre(), k.getKullaniciMail(), k.getKullaniciYetki());
		
	}
	
	private void kullanicilariGetir() {
		this.kullanicilar=ks.listKullanicilar();
	}
	
	@PostConstruct
    public void init() {
    	kullanicilariGetir();
    }

	public List<Kullanici> getKullanicilar() {
		return kullanicilar;
	}

	public void setKullanicilar(List<Kullanici> kullanicilar) {
		this.kullanicilar = kullanicilar;
	}

	public Integer getKullaniciId() {
		return kullaniciId;
	}

	public void setKullaniciId(Integer kullaniciId) {
		this.kullaniciId = kullaniciId;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showInfo() {
		addMessage(FacesMessage.SEVERITY_INFO, "Bilgilendirme", "Başarıyla Kaydedildi");
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

	public String getKullaniciYetki() {
		return kullaniciYetki;
	}

	public void setKullaniciYetki(String kullaniciYetki) {
		this.kullaniciYetki = kullaniciYetki;
	}

}
