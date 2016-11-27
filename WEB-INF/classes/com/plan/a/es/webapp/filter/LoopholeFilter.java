package com.plan.a.es.webapp.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * struts2 高危漏洞修复
 * 禁止struts2的某些功能，以保证服务安全，解除阿里云的报警
 * 
 * @author jimmy.zhou
 *
 */
public class LoopholeFilter extends OncePerRequestFilter {
	
	Logger log = Logger.getLogger(getClass());
	
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                 FilterChain chain)
            throws IOException, ServletException {
    	
    	Set<String> keySet = request.getParameterMap().keySet();
        for (String key : keySet) {
        	
        	/*
        	 * S2-016 漏洞修复
        	 */
            if ((key.contains("redirect:")) || (key.contains("redirectAction:")) || (key.contains("action:"))) {
                return;
            }
            
            /*
             * S2-020 漏洞修复
             */
            if(key.contains("class")) {
            	return;
            }
        }
        
        chain.doFilter(request, response);
		return;
    	
    }
    
}
