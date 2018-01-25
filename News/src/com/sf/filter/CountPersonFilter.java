package com.sf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


@WebFilter(filterName="CountPersonFilter",urlPatterns={"/index.jsp"},initParams={@WebInitParam(name="count",value="1000")})

public class CountPersonFilter implements Filter{
	private int count;   //ͳ������
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		count ++;
		ServletContext context = request.getServletContext();
		context.setAttribute("count", count);//�����ʵ������ŵ�ServletContext��
		chain.doFilter(request, response);  //���´��ݹ�����
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		String param = fconfig.getInitParameter("count"); //��ȡ��ʼ������
		count = Integer.valueOf(param);
		
	}
	
}
