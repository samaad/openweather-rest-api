package org.assessment.test;

import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class OpenweatherApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenweatherApiApplication.class, args);
    }

    private ObjectFactory<HttpMessageConverters> messageConverters = HttpMessageConverters::new;

    /**
     * @return
     */
    @Bean
    Encoder feignEncoder() {
        return new SpringEncoder(messageConverters);
    }

    /**
     * @return
     */
    @Bean
    Decoder feignDecoder() {
        return new SpringDecoder(messageConverters);
    }
}
