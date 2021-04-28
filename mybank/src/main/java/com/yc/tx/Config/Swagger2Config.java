package com.yc.tx.Config;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @program: testSpring
 * @description: lin
 * @author: Bauer
 * @create: 2021-04-27 19:39
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Value("${swagger.enabled}")
    private boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yc"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 生成的rest api的信息对象
     *
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("银行存取操作接口") //设置文档的标题
                .description("银行存取操作 API 接口文档") // 设置文档的描述
                .version("1.0") // 设置文档的版本信息-> 1.0.0 Version information
                .contact(new Contact("lin", "http://www.hyycinfo.com", "2723913812@qq.com"))
                .termsOfServiceUrl("http://www.hyycinfo.com")
                .build();
    }
}
