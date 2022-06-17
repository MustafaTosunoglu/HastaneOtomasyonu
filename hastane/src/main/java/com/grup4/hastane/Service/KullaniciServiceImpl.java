package com.grup4.hastane.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grup4.hastane.Entity.Doktor;
import com.grup4.hastane.Entity.DoktorHasta;
import com.grup4.hastane.Entity.DoktorUzmanlik;
import com.grup4.hastane.Entity.Hasta;
import com.grup4.hastane.Entity.Kullanici;
import com.grup4.hastane.Entity.Uzmanlik;


@Service
public class KullaniciServiceImpl implements KullaniciService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public boolean giris(String kullaniciAdi, String kullaniciSifre) {
		Query q = this.entityManager.createQuery("SELECT k FROM Kullanici k WHERE kullaniciAdi = :kullaniciAdi");
		q.setParameter("kullaniciAdi", kullaniciAdi);
		Kullanici k = null;
		try {
			k =(Kullanici) q.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return k != null && k.getKullaniciSifre().equals(kullaniciSifre);
	
	}

	@Override
	public String yetki(String kullaniciAdi) {
		Query q = this.entityManager.createQuery("SELECT k FROM Kullanici k WHERE kullaniciAdi = :kullaniciAdi");
		q.setParameter("kullaniciAdi", kullaniciAdi);
		Kullanici k=null;
		try {
			k =(Kullanici) q.getSingleResult();
		} catch (NoResultException e) {
			//e.printStackTrace();
		}
		
		if(k.getKullaniciYetki().equals("A")) return "A";
		else return "U";
	}
	
	@Override
	@Transactional
	public void kullaniciEkle(Integer kullaniciId, String kullaniciAdi, String kullaniciSifre, String kullaniciMail, String kullaniciYetki) {
		Kullanici k;
		boolean yeniKayit = kullaniciId == null;
		if(yeniKayit) {
			k = new Kullanici();
		} else {
			k = this.entityManager.find(Kullanici.class, kullaniciId);
		}
		k.setKullaniciAdi(kullaniciAdi);
		k.setKullaniciSifre(kullaniciSifre);
		k.setKullaniciMail(kullaniciMail);
		k.setKullaniciYetki(kullaniciYetki);
		if(yeniKayit) {
			this.entityManager.persist(k);			
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Uzmanlik> listUzmanliklar() {
		Query q = this.entityManager.createQuery("SELECT a FROM Uzmanlik a");
		return q.getResultList();
	}
	
	@Override
	@Transactional
	public void doktorEkle(String doktorAdi, String doktorSoyadi, String doktorSifre, String doktorMail) {
		Doktor k = new Doktor();
		k.setDoktorAdi(doktorAdi);
		k.setDoktorSoyadi(doktorSoyadi);
		k.setDoktorSifre(doktorSifre);
		k.setDoktorMail(doktorMail);
		
		DateFormat df = new SimpleDateFormat();
		Date today = Calendar.getInstance().getTime();
		String tarih = df.format(today);
		
		k.setDoktorKayitTarihi(tarih);
		
		this.entityManager.persist(k);
		
	}

	@Override
	@Transactional
	public void uzmanlikEkle(String uzmanlik) {
		Uzmanlik u=new Uzmanlik();
		u.setUzmanlikAdi(uzmanlik);
		this.entityManager.persist(u);
	}

	@Override
	@Transactional
	public void doktorUzmanlikEkle(Integer secilenDoktor, Integer secilenUzmanlik) {
		Doktor d=this.entityManager.find(Doktor.class, secilenDoktor);
		Uzmanlik u=this.entityManager.find(Uzmanlik.class, secilenUzmanlik);
		DoktorUzmanlik du = new DoktorUzmanlik();
		du.setDoktor(d);
		du.setUzmanlik(u);
		this.entityManager.persist(du);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Doktor> listDoktorlar() {
		Query q = this.entityManager.createQuery("SELECT m FROM Doktor m");
		return q.getResultList();
	}

	@Override
	public boolean girisDoktor(String doktorAdi, String doktorSifre) {
		Query q = this.entityManager.createQuery("SELECT k FROM Doktor k WHERE doktorAdi = :doktorAdi");
		q.setParameter("doktorAdi", doktorAdi);
		Doktor d = null;
		try {
			d =(Doktor) q.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return d != null && d.getDoktorSifre().equals(doktorSifre);
	}

	@Override
	@Transactional
	public void hastaEkle(String hastaTC, String hastaAdi, String hastaSoyadi, String hastaCinsiyet, String hastaTel, String hastaDogumTarihi, Integer secilenDoktor) {
		Hasta h = new Hasta();
		h.setHastaTC(hastaTC);
		h.setHastaAdi(hastaAdi);
		h.setHastaSoyadi(hastaSoyadi);
		h.setHastaCinsiyet(hastaCinsiyet);
		h.setHastaTel(hastaTel);
		h.setHastaDogumTarihi(hastaDogumTarihi);
		
		this.entityManager.persist(h);
		
		Doktor d=this.entityManager.find(Doktor.class, secilenDoktor);
		h=this.entityManager.find(Hasta.class, h.getHastaId());
		
		DoktorHasta dh = new DoktorHasta();
		dh.setDoktor(d);
		dh.setHasta(h);
		this.entityManager.persist(dh);
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Hasta> listHastalar() {
		Query q = this.entityManager.createQuery("SELECT m FROM Hasta m");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Kullanici> listKullanicilar() {
		Query q = this.entityManager.createQuery("SELECT k FROM Kullanici k");
		return q.getResultList();
	}
	

}
