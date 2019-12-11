package com.feng.web.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class WebFilter extends ZuulFilter{


    @Autowired
    private HttpServletRequest request;

    @Override
    public String filterType() {
        return "pre";
    }


    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取头
        RequestContext currentContext = RequestContext.getCurrentContext();
//        HttpServletRequest request = currentContext.getRequest();

        String header = request.getHeader("Authorization");

        if (header!=null && !"".equals(header)) {


            currentContext.addZuulRequestHeader("Authorization",header);
        }


        return null;
    }
}
