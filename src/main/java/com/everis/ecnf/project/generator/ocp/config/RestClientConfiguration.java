package com.everis.ecnf.project.generator.ocp.config;

import com.everis.ecnf.project.generator.ocp.proxy.PodApi;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;/*
import com.everis.ecnf.project.generator.ocp.proxy.RouteApi;
import com.everis.ecnf.core.http.utils.EcnfHttpClient;*/

@Slf4j
@Configuration
public class RestClientConfiguration {
/*
    @Bean
    PodApi getPods(
            @Value("https://ocpmasterdescal.financiero.bco:8443") String apiBaseUrl,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".connect-timeout:1000}") long connectTimeout,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".read-timeout:60000}") long readTimeout,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".write-timeout:1000}") long writeTimeout,
                    OkHttpClient.Builder builder) {
        //log.info("Creating AccountTransactionApi rest client");
        return EcnfHttpClient.builder()
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .writeTimeout(writeTimeout)
                .baseUrl(apiBaseUrl)
                .clientBuilder(builder)
                .buildProxy(PodApi.class);
    }

    @Bean
    RouteApi getRoutes(
            @Value("https://ocpmasterdescal.financiero.bco:8443") String apiBaseUrl,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".connect-timeout:1000}") long connectTimeout,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".read-timeout:60000}") long readTimeout,
            @Value("${application.http-client.ecnf.account-transaction"
                    + ".write-timeout:1000}") long writeTimeout,
            OkHttpClient.Builder builder) {
        //log.info("Creating AccountTransactionApi rest client");
        return EcnfHttpClient.builder()
                .connectTimeout(connectTimeout)
                .readTimeout(readTimeout)
                .writeTimeout(writeTimeout)
                .baseUrl(apiBaseUrl)
                .clientBuilder(builder)
                .buildProxy(RouteApi.class);
    }*/
}
