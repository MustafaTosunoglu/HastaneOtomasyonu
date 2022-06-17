package com.grup4.hastane.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grup4.hastane.Entity.Doktor;
import com.grup4.hastane.Entity.Hasta;
import com.grup4.hastane.Entity.Kullanici;
import com.grup4.hastane.Entity.Uzmanlik;

@Service
public interface KullaniciService {
	public boolean giris(String kullaniciAdi, String kullaniciSifre);
	public String yetki(String kullaniciAdi);
	public void kullaniciEkle(Integer kullaniciId, String kullaniciAdi, String kullaniciSifre, String kullaniciMail, String kullaniciYetki);
	public List<Uzmanlik> listUzmanliklar();
	public void doktorEkle(String doktorAdi, String doktorSoyadi, String doktorSifre, String doktorMail);
	public void uzmanlikEkle(String uzmanlik);
	public void doktorUzmanlikEkle(Integer secilenDoktor, Integer secilenUzmanlik);
	public List<Doktor> listDoktorlar();
	public boolean girisDoktor(String doktorAdi, String doktorSifre);
	public void hastaEkle(String hastaTC, String hastaAdi, String hastaSoyadi, String hastaCinsiyet, String hastaTel, String hastaDogumTarihi, Integer secilenDoktor);
	public List<Hasta> listHastalar();
	public List<Kullanici> listKullanicilar();

}
