package cn.figo.figo_zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @Author Figo
 * @Date 2020/3/12 19:18
 * 一个登录拦截器
 */
public class LoginFilter extends ZuulFilter {

    /**
     * 过滤器的类型有四种：pre route post error
     * @return
     */
    @Override
    public String filterType() {
        return null;
    }

    /**
     * 通过放回的int值来定义过滤器的优先级，数字越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否会执行，放回一个boolean值
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return false;
    }

    /**
     * 过滤器的具体业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
