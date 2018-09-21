package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 平台菜单资源
 * @author: libin
 * @date: 14:35 2018/9/21
 */
@Setter
@Getter
@ToString
public class Resource {

    /**
     * 资源id
     */
    private Long id;
    /**
     * 资源sign
     */
    private String sign;
    /**
     * 资源路径
     */
    private String path;
    /**
     * 父级资源
     */
    private Long pid;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 资源分支（多用于新老迭代，资源更替等场景）
     */
    private Integer branch;
}
