package cn.pw.pf.web.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: libin
 * @date: 19:16 2018/9/21
 */
public enum ResponseCode {

    SUCCESS(200, "操作成功", "SUCCESS"),
    FAILTURE(500, "系统错误", "FAILTURE");

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
