package cn.pw.pf.web.response;

import lombok.Getter;
import lombok.Setter;

/**
 * 接口相应码
 * @author: libin
 * @date: 19:16 2018/9/21
 */
public enum ResponseCode {

    SUCCESS(200, "操作成功", "SUCCESS"),
    FAILTURE(500, "系统错误", "FAILTURE"),
    SERVER_FALLBACK(10000,"后端服务调用失败","Backend service call failed"),
    USER_PWD_WRONG(20000,"用户名或密码错误","username or password was wrong");




    /**
     * 返回码
     */
    @Getter
    private int code;
    /**
     * 错误码描述
     */
    @Getter
    private String desc;
    /**
     * 英文描述
     */
    @Getter
    private String en;

    private ResponseCode(int code, String desc, String en) {
        this.code = code;
        this.desc = desc;
        this.en = en;
    }
}
