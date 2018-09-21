package cn.pw.pf.web.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 基于restfull的返回结果封装
 * @author: libin
 * @date: 19:00 2018/9/21
 */
@Setter
@Getter
@ToString
public class RestResponseResult<T> {

    /**
     * 自定义状态码
     * 成功：200
     * 系统错误：500
     * 其他：自定义业务码
     */
    private int code;
    /**
     * 展示信息
     * 用于用户提醒
     */
    private String message;
    /**
     * 返回错误原因
     * 用于开发人员定位问题
     */
    private String errors;
    /**
     * 返回的业务数据
     */
    private T data;
}
