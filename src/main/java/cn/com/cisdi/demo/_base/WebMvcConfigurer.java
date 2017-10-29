package cn.com.cisdi.demo._base;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

/**
 * MVC配置类
 *
 * @author Comup
 */
@EnableWebMvc
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 设置允许跨域请求
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true).maxAge(300);
    }

    /**
     * 设置上传文件大小限制
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //设置文件大小限制 ,超出设置页面会抛出异常信息，
        //这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize("64MB"); // KB,MB
        //设置总上传数据总大小
        factory.setMaxRequestSize("128MB");
        //Sets the directory location where files will be stored.
        //factory.setLocation("/root/image/upload")
        return factory.createMultipartConfig();
    }
}