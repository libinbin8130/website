package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: libin
 * @date: 10:05 2018/9/22
 */
public enum  Opration {

    CREATE(1,"CREATE");

    @Getter
    private Integer id;
    @Getter
    private String sign;

    private Opration(Integer id,String sign){
        this.id = id;
        this.sign = sign;
    }
}
