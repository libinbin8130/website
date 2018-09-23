package cn.pw.pf.web.exception;

import cn.pw.pf.web.response.RestResponseResult;
import cn.pw.pf.web.response.RestResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局处理接口异常，返回统一信息。
 *
 * @Description:
 * @Author:libin
 * @Date: Created in 15:49 2018/1/2
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 异常拦截，抛出ServletException
     *
     * @param request
     * @param response
     * @param e
     * @return
     * @throws ServletException
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public RestResponseResult<?> defaultCachException(HttpServletRequest request, HttpServletResponse response, Throwable e) throws ServletException {
        if (e instanceof ServletException) {
            logger.warn("request error! {}", e);
            HttpStatus status = getStatus(request);
            return RestResultGenerator.servletException(status, e.getMessage());
        }
        if (e instanceof CustomerException) {
            logger.warn("business error! {}", ((CustomerException) e).getResponseCode().getEn());
            return RestResultGenerator.failture(((CustomerException) e).getResponseCode(), e.getMessage());
        }
        logger.error("system error! {}", e);
        return RestResultGenerator.systemFailture(e);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
