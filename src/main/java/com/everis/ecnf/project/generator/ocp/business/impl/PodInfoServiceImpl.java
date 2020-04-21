package com.everis.ecnf.project.generator.ocp.business.impl;


import com.everis.ecnf.project.generator.ocp.business.PodInfoService;
import com.everis.ecnf.project.generator.ocp.model.Info;
import com.everis.ecnf.project.generator.ocp.model.PodResponse;
import com.everis.ecnf.project.generator.ocp.model.RouteResponse;
import com.everis.ecnf.project.generator.ocp.model.route.RouteInfo;
import com.everis.ecnf.project.generator.ocp.proxy.PodApi;
import com.everis.ecnf.project.generator.ocp.proxy.RouteApi;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class PodInfoServiceImpl implements PodInfoService {
/*
    @Autowired
    PodApi podApi;

    @Autowired
    RouteApi routesApi;

    private String token = "Bearer DcU1mzNCHj0Od0oibAFvRmh29l6LPzmDHKjhLZLzDZE";

    public Flux<Info> getInfo(String namespace) {

        return podApi.getPods(namespace, token)
       .map(Builder::new)
       .zipWith(routesApi.getRoutes(namespace,token))
       .map( r ->  r.getT1().withReponseRoute(r.getT2()))
       .flatMapMany( (d) -> { return  d.build();});
    return null;
    }

    @Data
    private class Builder{
        PodResponse responsePod;
        Map<String,RouteInfo> map;

        Builder(PodResponse response){
            this.responsePod = response;
        }

        public  Builder withReponseRoute(RouteResponse responseRoute){
            map = responseRoute.getItems().stream()
                    .collect(Collectors.toMap((entry) ->  entry.getMetadata().getLabels()!=null?
                                                          entry.getMetadata().getLabels().getApp()
                                                         :entry.getMetadata().getName()
                            ,(entry) -> entry));
            return this;
        }

       public Flux<Info> build(){
            return Flux.fromStream(responsePod.getItems().stream())
                   .map(r -> Info.builder()
                                .name(r.getMetadata().getName())
                                .status(r.getStatus().getPhase())
                                .app(r.getMetadata().getLabels().getApp())
                                .route(map.get(r.getMetadata().getLabels().getApp()).getMetadata().getSelfLink())
                                .build());
       }
    }


*/
}
