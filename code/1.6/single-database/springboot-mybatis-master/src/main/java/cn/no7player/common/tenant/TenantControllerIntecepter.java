package cn.no7player.common.tenant;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义controller 拦截器
 * 存储租户信息 判断是操作哪个DB
 * client 通过 get方式传递 tenant
 * 或者 直接用 TenantContextHolder.setTenant
 */
public class TenantControllerIntecepter implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(TenantControllerIntecepter.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String tenant = httpServletRequest.getParameter("tenant");
        logger.info("========tenant=========== "+tenant);
        if(tenant!=null &&
                tenant.toString().trim().length() > 0
        ){
            TenantContextHolder.setTenant(tenant);
        }
        else{
            logger.info("=====无效的tenant====="+tenant);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {

    }
}
