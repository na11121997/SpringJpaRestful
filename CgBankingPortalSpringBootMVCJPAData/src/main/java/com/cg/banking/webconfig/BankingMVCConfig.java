package com.cg.banking.webconfig;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
@Configuration
public class BankingMVCConfig implements WebMvcConfigurer{
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver ref=new InternalResourceViewResolver();
		ref.setPrefix("/views/");
		ref.setSuffix(".jsp");
		return ref;
	}
	@Bean
	public MessageSource getMessageSource() {
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		System.out.println(messageSource.getBasenameSet());
		return messageSource;
	}
}
