package com.test.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.test.bean.User;
import com.test.service.User_operation;

/**
 * Servlet Filter implementation class AutoLoginFilter
 */
@WebFilter("/AutoLoginFilter")
public class AutoLoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutoLoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse rep, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
		Cookie[] cookies = request.getCookies();
		String autoLogin = null;
		for(int i =0;cookies != null&&i < cookies.length;i++) {
			if("autoLogin".equals(cookies[i].getName()));{
				autoLogin = cookies[i].getValue();
				break;
			}
		}
		if(autoLogin!=null) {
			String[] parts = autoLogin.split("-");
			String username = parts[0];
			String password = parts[1];
			User_operation user1_op = new User_operation();
			boolean x = false;
			try {
				if(x  = user1_op.user_exist(username)) {
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(x){//存在此用户名
				
				User user1 = null;
				try {
					user1 = user1_op.find_user_by_name(username);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(password.equals(user1.getPassword())){	
					request.getSession().setAttribute("user", user1);}
			}
			
		}
		
		
		
		
		
		
		
		
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
