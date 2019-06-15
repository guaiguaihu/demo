package com.example.demo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.DateFormat;

/**
 * WebMvcConfig
 *
 * @author liujinliang
 * @date 2019/6/9
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new DateConverter());
    }

    @Autowired
    private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;

    @Bean
    public MappingJackson2HttpMessageConverter MappingJsonpHttpMessageConverter() {

        ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
        DateFormat dateFormat = mapper.getDateFormat();
        mapper.setDateFormat(new DemoDateFormat(dateFormat));
        MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
                mapper);
        return mappingJsonpHttpMessageConverter;
    }
}
