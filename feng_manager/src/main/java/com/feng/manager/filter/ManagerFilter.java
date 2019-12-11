package com.feng.manager.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import util.JwtUtil;
import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends  ZuulFilter{

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 在请求前pre 在请求后post
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 当前过滤器是否开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作
     * s
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        System.out.println("经过了Zuul过滤器!");
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        //登录页面不拦截
        String url=request.getRequestURL().toString();
        if(url.indexOf("/admin/login")>0){
            System.out.println("登陆页面"+url);
            return null;
        }
        String header = request.getHeader("Authorization");
        if(StringUtils.isEmpty(header))
            throw new RuntimeException("验证失败！");
        if(!header.startsWith("Bearor "))
            throw new RuntimeException("验证失败！");
        String token = header.substring(7);

        try{
            Claims claims = jwtUtil.parseJWT(token);
            System.out.println(claims.get("roles"));
            if("admin".equals(claims.get("roles"))) {

                currentContext.addZuulRequestHeader("Authorization", header);
                return null;
            }

        }catch (Exception e){
            throw new RuntimeException("token验证失败！");
        }

        currentContext.setSendZuulResponse(false);//终止运行
        currentContext.setResponseStatusCode(401);//http状态码
        currentContext.setResponseBody("无权访问");
        currentContext.getResponse().setContentType("text/html;charset=UTF-8");
        return null;
    }
}
