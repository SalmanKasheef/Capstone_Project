package com.ltimindtree.Filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class Order_Filter implements Filter {

	Logger logger =LoggerFactory.getLogger(Order_Filter.class);
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("Inside Order Filter");
		logger.info("Local Port : "+request.getLocalPort());
		logger.info("Server Name : "+request.getServerName());
		
		HttpServletRequest httpServletRequest=(HttpServletRequest) request;
		logger.info("Method Name : "+httpServletRequest.getMethod());
		logger.info("Request URI : "+httpServletRequest.getRequestURI());
		logger.info("Servlet Path : "+httpServletRequest.getServletPath());
		chain.doFilter(request, response);
		
	}

}
