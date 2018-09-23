package cn.pw.pf.web.exception;

import cn.pw.pf.web.response.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义业务异常
 *
 * @author: libin
 * @date: 19:31 2018/9/21
 */
@Setter
@Getter
public class CustomerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private ResponseCode responseCode;
    private String message;

    public CustomerException(String message, Throwable cause, ResponseCode responseCode) {
        super(message, cause);
        this.responseCode = responseCode;
        this.message = message;
    }

    public CustomerException(String message, ResponseCode responseCode) {
        this(message, (Throwable) null, responseCode);
    }

}
