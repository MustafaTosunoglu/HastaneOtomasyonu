package com.grup4.hastane.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grup4.hastane.Entity.Doktor;
import com.grup4.hastane.Entity.Hasta;
import com.grup4.hastane.Entity.Kullanici;
import com.grup4.hastane.Entity.Uzmanlik;
import com.grup4.hastane.Service.KullaniciService;

@RestController
@RequestMapping("/rest")
public class KullaniciController {
	
	@Autowired
	KullaniciService kullaniciService;
	
	@GetMapping(value = "/giris")
	public boolean giris(@RequestParam String kullaniciAdi, @RequestParam String kullaniciSifre) {
		return this.kullaniciService.giris(kullaniciAdi, kullaniciSifre);
	}

	public String yetki(@RequestParam String kullaniciAdi) {
		return this.kullaniciService.yetki(kullaniciAdi);
	}
	
	public void kullaniciEkle(@RequestParam String kullaniciAdi,@RequestParam String kullaniciSifre, @RequestParam String kullaniciMail, @RequestParam String kullaniciYetki) {
		this.kullaniciService.kullaniciEkle(null, kullaniciAdi, kullaniciSifre, kullaniciMail, kullaniciYetki);
	}
	
	public void doktorEkle(@RequestParam String doktorAdi,@RequestParam String doktorSoyadi, @RequestParam String doktorSifre, @RequestParam String doktorMail) {
		this.kullaniciService.doktorEkle(doktorAdi, doktorSoyadi, doktorSifre, doktorMail);
	}

	public void uzmanlikEkle(@RequestParam String uzmanlik) {
		this.kullaniciService.uzmanlikEkle(uzmanlik);
	}

	public void doktorUzmanlikEkle(@RequestParam Integer secilenDoktor,@RequestParam Integer secilenUzmanlik) {
		this.kullaniciService.doktorUzmanlikEkle(secilenDoktor,secilenUzmanlik);
	}

	public List<Uzmanlik> listUzmanliklar() {
		return this.kullaniciService.listUzmanliklar();
	}

	public List<Doktor> listDoktorlar() {
		return this.kullaniciService.listDoktorlar();
	}
	
	@GetMapping(value = "/girisDoktor")
	public boolean girisDoktor(@RequestParam String doktorAdi,@RequestParam String doktorSifre) {
		return this.kullaniciService.girisDoktor(doktorAdi, doktorSifre);
	}

	public void hastaEkle(@RequestParam String hastaTC,@RequestParam String hastaAdi,@RequestParam String hastaSoyadi,@RequestParam String hastaCinsiyet,@RequestParam String hastaTel,@RequestParam String hastaDogumTarihi,@RequestParam Integer secilenDoktor) {
		this.kullaniciService.hastaEkle(hastaTC, hastaAdi, hastaSoyadi, hastaCinsiyet, hastaTel, hastaDogumTarihi, secilenDoktor);
		
	}

	public List<Hasta> listHastalar() {
		return this.kullaniciService.listHastalar();
	}


	public void kullaniciGuncelle(@RequestParam Integer kullaniciId,@RequestParam String kullaniciAdi,@RequestParam String kullaniciSifre,@RequestParam String kullaniciMail,@RequestParam String kullaniciYetki) {
		this.kullaniciService.kullaniciEkle(kullaniciId, kullaniciAdi, kullaniciSifre, kullaniciMail, kullaniciYetki );
		
	}

	public List<Kullanici> listKullanicilar() {
		return this.kullaniciService.listKullanicilar();
	}
	

}
