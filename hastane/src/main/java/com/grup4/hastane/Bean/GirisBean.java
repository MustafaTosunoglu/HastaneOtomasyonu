package com.grup4.hastane.Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grup4.hastane.Controller.KullaniciController;


@Component
@ManagedBean(name = GirisBean.BEAN_NAME)
@SessionScoped
public class GirisBean {
	public static final String BEAN_NAME = "girisBean";
	private String kullaniciAdi;
	private String kullaniciSifre;

	@Autowired
	private KullaniciController kc;
	
	
	public String giris() {
		boolean giris = this.kc.giris(this.kullaniciAdi, this.kullaniciSifre);
		if (giris) {
			if (this.kc.yetki(kullaniciAdi).equals("A"))
				return "/girisAdmin.xhtml";
			else
				return "/girisUser.xhtml"
						;
		}

		else {

			return "/uyari.xhtml";
		}
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
	
	
}
