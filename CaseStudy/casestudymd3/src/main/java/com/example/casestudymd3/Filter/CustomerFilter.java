package com.example.casestudymd3.Filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println(2);
        if (isAuthenticated(request)) {
            filterChain.doFilter(request, response);
            return;
        }
        response.sendRedirect("/home");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private boolean isAuthenticated(HttpServletRequest request) throws NullPointerException{
        return request.getSession(false) != null && request.getSession().getAttribute("role").equals("customer");
    }
}
