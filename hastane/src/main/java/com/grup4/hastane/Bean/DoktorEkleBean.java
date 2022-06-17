package com.grup4.hastane.Bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import com.grup4.hastane.Controller.KullaniciController;

@RequestScope
@Named(DoktorEkleBean.BEAN_NAME)
public class DoktorEkleBean implements Serializable {

	public static final String BEAN_NAME = "doktorEkleBean";

	private String doktorAdi;
	private String doktorSoyadi;
	private String doktorSifre;
	private String doktorMail;

	@Autowired
	private KullaniciController ks;

	public void doktorEkle() {

		this.ks.doktorEkle(this.doktorAdi, this.doktorSoyadi, this.doktorSifre, this.doktorMail);
		showInfo();

		this.doktorAdi = null;
		this.doktorSoyadi = null;
		this.doktorSifre = null;
		this.doktorMail = null;
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showInfo() {
		addMessage(FacesMessage.SEVERITY_INFO, "Bilgilendirme", "Başarıyla Kaydedildi");
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
	
	

}
