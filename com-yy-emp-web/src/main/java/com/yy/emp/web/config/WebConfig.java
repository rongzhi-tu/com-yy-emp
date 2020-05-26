package com.yy.emp.web.config;

import com.yy.base.common.YyLocalResolver;
import com.yy.sso.config.LoginInercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by tuz
 * on 2020/5/15.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public LoginInercepter loginInercepter(){
        return new LoginInercepter();
    }
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer(){
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/index.html").setViewName("login");
//                registry.addViewController("/main.html").setViewName("main");
//            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Date>() {
                    @Nullable
                    @Override
                    public Date convert(String source) {
                        if(null != source && !source.equals("")) {
                            String pattern = "yyyy-MM-dd";
                            int len = source.length();
                            if(len == 7) {
                                pattern = "yyyy-MM";
                            } else if(len == 19) {
                                pattern = "yyyy-MM-dd HH:mm:ss";
                            }

                            SimpleDateFormat format = new SimpleDateFormat(pattern);

                            try {
                                return format.parse(source);
                            } catch (ParseException var6) {
                                var6.printStackTrace();
                                return null;
                            }
                        } else {
                            return null;
                        }
                    }
                });
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源不需要处理，可以正常访问。springboot已经做好了静态资源映射
                registry.addInterceptor(loginInercepter()).addPathPatterns("/**")
                        .excludePathPatterns("/","login","/login", "/login.html","/verifimg**",
                                "/user/login", "/**/*.css", "/**/*.js", "/**/*.png",
                                "/**/*.jpg","/**/*.jpeg", "/**/*.gif", "/**/fonts/*",
                                "/**/*.svg","/**/*.ico","/**/*.map","/favicon.ico");
                //静态资源 springboot都已经处理好  不用再去处理
            }
        };

    }

    @Bean
    public LocaleResolver localeResolver(){
        return new YyLocalResolver();
    }
}
