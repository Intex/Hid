package hid.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@ComponentScan(basePackages = "hid")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions(new String[] { "/WEB-INF/configs/tiles.xml" });
		return configurer;
	}

	@Bean
	public ViewResolver getTilesViewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setViewClass(TilesView.class);
		resolver.setOrder(0);
		return resolver;
	}

	@Bean
	public ViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/pages/");
		resolver.setSuffix(".jsp");
		resolver.setOrder(1);		
		return resolver;
	}	
	
	// Static resource (js, css files, images etc) 	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*.js", "*.css", "*.txt").addResourceLocations(
				"/resources/");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/lang/errors");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
}
