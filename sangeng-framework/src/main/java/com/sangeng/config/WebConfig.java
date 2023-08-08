package com.sangeng.config;


import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.sangeng.properties.AliOssProperties;
import com.sangeng.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
@Slf4j
class WebConfig implements WebMvcConfigurer {

    //生成OSS工具类对象
    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(AliOssProperties aliOssProperties){
        log.info("开始创建阿里云文件上传工具类对象：{}",aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 设置允许跨域的路径
        registry.addMapping("/**")
                // 设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                // 是否允许cookie
                .allowCredentials(true)
                // 设置允许的请求方式
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                // 设置允许的header属性
                .allowedHeaders("*")
                // 跨域允许时间
                .maxAge(3600);
    }


    //使用Swagger：
    @Bean
    public Docket docket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("苍穹外卖项目接口文档")
                .version("2.0")
                .description("苍穹外卖项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sangeng.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    //设置静态资源映射，否则接口文档页面无法访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    @Bean//用于创建一个HttpMessageConverter类型的Bean
    //FastJson 是阿里巴巴开源的一款高性能 JSON 解析库，它是一个用于处理 JSON 格式数据的 Java 库。FastJson 提供了非常快速、高效的 JSON 解析和生成功能
    public HttpMessageConverter fastJsonHttpMessageConverters() {
        //1.FastJsonHttpMessageConverter是FastJson库为了与Spring框架集成而提供的一个实现了HttpMessageConverter接口的类。
        // 它通过FastJson库来实现将Java对象与JSON数据进行转换，同时允许你在转换时自定义FastJson的配置。
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //FastJsonConfig 是 FastJson 库中的一个配置类，用于定制 FastJson 库的行为
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //序列化时的格式化选项，使得生成的JSON数据格式化显示，更易读。
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //设置日期格式化的格式
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
        //设置 FastJson 在序列化 Long 类型时，将其转换为字符串，以避免前端在处理大数字时丢失精度的问题。
        SerializeConfig.globalInstance.put(Long.class, ToStringSerializer.instance);
        //把设置加入配置
        fastJsonConfig.setSerializeConfig(SerializeConfig.globalInstance);
        //启用自定义配置
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //类型转换
        HttpMessageConverter<?> converter = fastConverter;
        return converter;
    }

    //把新建的concerter（消息转换器）并将其添加到消息转换器列表 converters中
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(fastJsonHttpMessageConverters());
    }


}
