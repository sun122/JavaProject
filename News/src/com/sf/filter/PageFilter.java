package com.sf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String path = req.getRequestURI();

		if(path.equals("/News/admin/addcatelog.jsp") || path.equals("/News/admin/AddImg.jsp") || path.equals("/News/admin/addnews.jsp") || path.equals("/News/admin/addUser.jsp") || path.equals("/News/admin/addimagenews.jsp")){
			chain.doFilter(request, response);	
		}else{
			resp.sendRedirect(req.getContextPath()+"/adminlogin.jsp");
			chain.doFilter(request, response);		
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
