package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 用户权限
 *
 * @author: libin
 * @date: 14:41 2018/9/21
 */
@Getter
@Setter
public class Permission {

    private Resource resource;
    /**
     * 对资源的操作，多项操作二进制 | 运算结果。
     */
    private List<Opration> oprations;
}
