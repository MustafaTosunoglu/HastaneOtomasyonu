package com.grup4.hastane.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.web.context.annotation.RequestScope;

import com.grup4.hastane.Controller.KullaniciController;
import com.grup4.hastane.Entity.Doktor;
import com.grup4.hastane.Entity.Uzmanlik;

@RequestScope
@Named(DoktorUzmanlikEkleBean.BEAN_NAME)
public class DoktorUzmanlikEkleBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String BEAN_NAME = "doktorUzmanlikEkleBean";

	private List<Doktor> doktorlar;
	private List<Uzmanlik> uzmanliklar;

	private Integer secilenDoktor;
	private Integer secilenUzmanlik;

    @Inject
	private KullaniciController ks;

	public void kaydet() {
		if (this.secilenDoktor != null && this.secilenUzmanlik != null) {
		this.ks.doktorUzmanlikEkle(this.secilenDoktor, this.secilenUzmanlik);
			showInfo();
		}
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showInfo() {
		addMessage(FacesMessage.SEVERITY_INFO, "Bilgilendirme", "Başarıyla Kaydedildi");
	}

	@PostConstruct
	public void init() {
		doktorlariGetir();
		uzmanliklariGetir();
	}

	private void uzmanliklariGetir() {
		this.uzmanliklar = this.ks.listUzmanliklar();	
	}

	private void doktorlariGetir() {
		this.doktorlar = this.ks.listDoktorlar();

	}

	public Integer getSecilenDoktor() {
		return secilenDoktor;
	}

	public void setSecilenDoktor(Integer secilenDoktor) {
		this.secilenDoktor = secilenDoktor;
	}

	public Integer getSecilenUzmanlik() {
		return secilenUzmanlik;
	}

	public void setSecilenUzmanlik(Integer secilenUzmanlik) {
		this.secilenUzmanlik = secilenUzmanlik;
	}

	public List<Doktor> getDoktorlar() {
		return doktorlar;
	}

	public void setDoktorlar(List<Doktor> doktorlar) {
		this.doktorlar = doktorlar;
	}

	public List<Uzmanlik> getUzmanliklar() {
		return uzmanliklar;
	}

	public void setUzmanliklar(List<Uzmanlik> uzmanliklar) {
		this.uzmanliklar = uzmanliklar;
	}

}
