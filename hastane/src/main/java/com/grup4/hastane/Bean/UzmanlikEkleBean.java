package com.grup4.hastane.Bean;

import java.io.Serializable;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.RequestScope;

import com.grup4.hastane.Controller.KullaniciController;


@RequestScope
@Named(UzmanlikEkleBean.BEAN_NAME) 
public class UzmanlikEkleBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String BEAN_NAME = "UzmanlikEkleBean";
	
	private String uzmanlik;

	@Autowired
	private KullaniciController ks;
	
	public void uzmanlikEkle() {
		this.ks.uzmanlikEkle(this.uzmanlik);
		this.uzmanlik=null;
	}

	public String getUzmanlik() {
		return uzmanlik;
	}

	public void setUzmanlik(String uzmanlik) {
		this.uzmanlik = uzmanlik;
	}
	
	
}
