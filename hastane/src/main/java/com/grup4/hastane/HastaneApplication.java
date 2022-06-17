package com.grup4.hastane;

import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.sun.faces.config.ConfigureListener;



@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan("com.grup4")
public class HastaneApplication implements ServletContextInitializer{

	public static void main(String[] args)  {
		SpringApplication.run(HastaneApplication.class, args);
	}
	//JSF Configration Başlangıc
	@Bean
	public ServletRegistrationBean<FacesServlet> facesServletRegistraiton() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean<FacesServlet>(servlet, "*.xhtml");
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

	@Bean
	public ServletRegistrationBean<FacesServlet> jsfServletRegistration(ServletContext servletContext) {
		// spring boot only works if this is set
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

		// FacesServlet registration
		ServletRegistrationBean<FacesServlet> srb = new ServletRegistrationBean<FacesServlet>();
		srb.setServlet(new FacesServlet());
		srb.setUrlMappings(Arrays.asList("*.xhtml"));
		srb.setLoadOnStartup(1);
		return srb;
	}
    //JSF Configration Sonu
    
    @Autowired
	Environment env;
    
    @Bean
	@ConfigurationProperties("spring.datasource")
	@Primary
	public DataSource mainDataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));

		return dataSource;
	}
    
    @Bean
    public ServletContextInitializer servletContextInitializer() {
        return servletContext -> {
            servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
            //Primefacesin ücretsiz temalarından bootstrap örneği yaptık değiştirebilirsiniz
            servletContext.setInitParameter("primefaces.THEME", "bootstrap");
            //Primefaces client browser tarafında kontrol edilebilme örneğin textbox 10 karakter olmalı vs..
            servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", Boolean.TRUE.toString());
            //Xhtml sayfalarında commentlerin parse edilmemesi.
            servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", Boolean.TRUE.toString());
            //primefaces icon set için
            servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString()); };
    }
    
    @Bean
	public FacesServlet facesServlet() {
		return new FacesServlet();
	}
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("primefaces.FONT_AWESOME", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
		servletContext.setInitParameter("javax.faces.INTERPRET_EMPTY_STRING_SUBMITTED_VALUES_AS_NULL",Boolean.TRUE.toString());
		servletContext.setInitParameter("javax.faces.PARTIAL_STATE_SAVING", Boolean.FALSE.toString());
		servletContext.setInitParameter("javax.faces.PROJECT_STAGE", "Production");
		servletContext.setInitParameter("primefaces.UPLOADER", "commons");
		servletContext.setInitParameter("javax.faces.STATE_SAVING_METHOD", "client");
		servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
		servletContext.setInitParameter("primefaces.THEME", "flick"); 
		jsfServletRegistration(servletContext);
		
	}

}


