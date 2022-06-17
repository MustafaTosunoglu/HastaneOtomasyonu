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
import com.grup4.hastane.Entity.Doktor;
import com.grup4.hastane.Entity.Hasta;


@RequestScope
@Named(HastaEkleBean.BEAN_NAME)
public class HastaEkleBean implements Serializable {

	public static final String BEAN_NAME = "hastaEkleBean";
	
	private String hastaTC;
	private String hastaAdi;
	private String hastaSoyadi;
	private String hastaCinsiyet;
	private String hastaTel;
	private String hastaDogumTarihi;
	
	private List<Doktor> doktorlar;
	private Integer secilenDoktor;
	
	//Güncelle Kısmı
	
	private List<Hasta> hastalar;
 

	@Autowired
	private KullaniciController ks;
	
	@PostConstruct
	public void init() {
		doktorlariGetir();
		hastalariGetir();
	}

	public void hastaEkle() {

		this.ks.hastaEkle(this.hastaTC, this.hastaAdi, this.hastaSoyadi, this.hastaCinsiyet, this.hastaTel, this.hastaDogumTarihi, this.secilenDoktor);
		showInfo();

		this.hastaTC = null;
		this.hastaAdi = null;
		this.hastaSoyadi = null;
		this.hastaCinsiyet = null;
		this.hastaTel = null;
		this.hastaDogumTarihi = null;
		this.secilenDoktor = null;
		
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showInfo() {
		addMessage(FacesMessage.SEVERITY_INFO, "Bilgilendirme", "Başarıyla Kaydedildi");
	}
	
	private void doktorlariGetir() {
		this.doktorlar = this.ks.listDoktorlar();

	}
	
	private void hastalariGetir() {
		this.hastalar = this.ks.listHastalar();

	}

	public Integer getSecilenDoktor() {
		return secilenDoktor;
	}

	public void setSecilenDoktor(Integer secilenDoktor) {
		this.secilenDoktor = secilenDoktor;
	}
	
	public List<Doktor> getDoktorlar() {
		return doktorlar;
	}

	public void setDoktorlar(List<Doktor> doktorlar) {
		this.doktorlar = doktorlar;
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

	public List<Hasta> getHastalar() {
		return hastalar;
	}

	public void setHastalar(List<Hasta> hastalar) {
		this.hastalar = hastalar;
	}
	
	

}
