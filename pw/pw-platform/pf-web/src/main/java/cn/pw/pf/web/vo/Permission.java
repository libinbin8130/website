package cn.pw.pf.web.vo;

/**
 * 用户权限
 * @author: libin
 * @date: 14:41 2018/9/21
 */
public class Permission {

    private Long id;
    /**
     * 资源id
     */
    private Long resourceId;
    /**
     * 对资源的操作，多项操作二进制 | 运算结果。
     */
    private Integer oprations;
}
