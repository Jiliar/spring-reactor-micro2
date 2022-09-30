package com.jsolution.config;

import com.jsolution.handler.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routesInvoice(InvoiceHandler handler){
        return route(GET("/v2/invoices"), handler::findAll)
                .andRoute(GET("/v2/invoices/{id}"), handler::findById)
                .andRoute(POST("/v2/invoices"), handler::create)
                .andRoute(PUT("/v2/invoices/{id}"), handler::update)
                .andRoute(DELETE("/v2/invoices/{id}"), handler::delete);
    }

}
