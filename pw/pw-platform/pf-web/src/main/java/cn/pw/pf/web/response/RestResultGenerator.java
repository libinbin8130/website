package cn.pw.pf.web.response;

import org.springframework.http.HttpStatus;

/**
 * 返回值方法工厂
 *
 * @author: libin
 * @date: 19:10 2018/9/21
 */
public class RestResultGenerator {

    /**
     * 成功，无数据返回
     *
     * @param <T>
     * @return
     */
    public static <T> RestResponseResult<T> success() {
        RestResponseResult<T> result = new RestResponseResult<T>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getDesc());
        return result;
    }

    /**
     * 成功，返回数据data
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> RestResponseResult<T> success(T data) {
        RestResponseResult<T> result = new RestResponseResult<T>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(ResponseCode.SUCCESS.getDesc());
        result.setData(data);
        return result;
    }

    /**
     * 失败，返回错误码和用户提示
     *
     * @param responseCode
     * @param message
     * @param <T>
     * @return
     */
    public static <T> RestResponseResult<T> failture(ResponseCode responseCode, String message) {
        RestResponseResult<T> result = new RestResponseResult<T>();
        result.setCode(ResponseCode.SUCCESS.getCode());
        result.setMessage(message);
        result.setErrors(ResponseCode.SUCCESS.getDesc());
        return result;
    }

    /**
     * 系统错误，一般为系统异常
     *
     * @param e
     * @param <T>
     * @return
     */
    public static <T> RestResponseResult<T> systemFailture(Throwable e) {
        RestResponseResult<T> result = new RestResponseResult<T>();
        result.setCode(ResponseCode.FAILTURE.getCode());
        result.setMessage(ResponseCode.FAILTURE.getDesc());
        result.setErrors(e.getMessage());
        return result;
    }

    /**
     * 请求异常，处理servelet拦截的异常信息
     *
     * @param status
     * @param exceptionErrors
     * @param <T>
     * @return
     */
    public static <T> RestResponseResult<T> servletException(HttpStatus status, String exceptionErrors) {
        RestResponseResult<T> result = new RestResponseResult<T>();
        result.setCode(status.value());
        result.setMessage(exceptionErrors);
        result.setErrors(exceptionErrors);
        return result;
    }
}
