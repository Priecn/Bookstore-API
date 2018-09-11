package com.prince.bookstoreapi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RequestFilter implements Filter{

    private static final Logger logger = LoggerFactory.getLogger(RequestFilter.class);
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, x-auth-token");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if(!(request.getMethod().equalsIgnoreCase("OPTIONS"))){
            try {
                Enumeration<String> headers = request.getHeaderNames();
                logger.warn("******************************");
                logger.warn(request.getRequestURL().toString());
                while(headers.hasMoreElements()) {
                    String h = headers.nextElement();
                    logger.warn(h+": "+ request.getHeader(h));
                }
                logger.warn("*******************************");
                chain.doFilter(req, res);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            logger.warn("*******************************");
            logger.warn(request.getRequestURL().toString());
            logger.warn("x-auth-token: "+request.getHeader("x-auth-token"));
            logger.warn("Authorization: "+request.getHeader("Authorization"));
            logger.warn("*******************************");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type," +
                    "x-auth-token, Access-Control-Request-Headers, Access-Control-Request-Method," +
                    "Accept, Origin, x-requested-with");
            response.setStatus(HttpServletResponse.SC_OK);

        }
    }

    public void init(FilterConfig config){}

    public void destroy() {}
}
