package cn.figo.figo_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author Figo
 * @Date 2020/3/12 19:18
 * 一个登录拦截器
 */
@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器的类型有四种：pre route post error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 通过放回的int值来定义过滤器的优先级，数字越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 10;
    }

    /**
     * 判断该过滤器是否会执行（是否执行run方法），放回一个boolean值,true就会执行run方法
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体业务逻辑
     * 访问 http://localhost:10010/service-provider/user/42?token=xxx
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        // 初始化context上下文对象，servlet spring
        RequestContext context = RequestContext.getCurrentContext();
        //获取request对象
        HttpServletRequest request = context.getRequest();
        //获取参数
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)){
            // 如果模拟的登录参数为空，则不转发请求
            context.setSendZuulResponse(false);
            // 响应状态码，401-身份未认证
            context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            // 设置响应提示
            context.setResponseBody("request error!");
        }
        // 返回值null，就代表该过滤器啥都不做
        return null;
    }
}
