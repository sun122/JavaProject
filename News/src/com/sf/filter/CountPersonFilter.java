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
	private int count;   //统计数量
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		count ++;
		ServletContext context = request.getServletContext();
		context.setAttribute("count", count);//将访问的数量放到ServletContext中
		chain.doFilter(request, response);  //向下传递过滤器
	}

	@Override
	public void init(FilterConfig fconfig) throws ServletException {
		String param = fconfig.getInitParameter("count"); //获取初始化参数
		count = Integer.valueOf(param);
		
	}
	
}
