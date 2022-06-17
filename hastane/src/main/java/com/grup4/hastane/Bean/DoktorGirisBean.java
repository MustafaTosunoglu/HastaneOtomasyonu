package com.grup4.hastane.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grup4.hastane.Controller.KullaniciController;


@Component
@ManagedBean(name = DoktorGirisBean.BEAN_NAME)
@SessionScoped
public class DoktorGirisBean {
	public static final String BEAN_NAME = "doktorGirisBean";
	private String doktorAdi;
	private String doktorSifre;

	@Autowired
	private KullaniciController kc;
	
	
	public String girisDoktor() {
		boolean giris = this.kc.girisDoktor(this.doktorAdi, this.doktorSifre);
		if (giris) {
			return "/girisDok.xhtml";
		}

		else {

			return "/uyari.xhtml";
		}
	}


	public String getDoktorAdi() {
		return doktorAdi;
	}


	public void setDoktorAdi(String doktorAdi) {
		this.doktorAdi = doktorAdi;
	}


	public String getDoktorSifre() {
		return doktorSifre;
	}


	public void setDoktorSifre(String doktorSifre) {
		this.doktorSifre = doktorSifre;
	}
	
	
	
	
}
