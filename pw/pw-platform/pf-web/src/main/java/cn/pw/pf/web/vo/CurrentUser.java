package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

/**
 * 当前登录用户
 * @author: libin
 * @date: 14:34 2018/9/21
 */
@Getter
@Setter
@ToString
public class CurrentUser {

    /**
     * 当前用户id
     */
    private Long id;
    /**
     * 当前用户登录名
     */
    private String userName;
    /**
     * 当前用户姓名
     */
    private String realName;
    /**
     * 当前用户类型
     */
    private Integer type;
    /**
     * 上次一次登录日期
     */
    private Long lastLoginDate;
    /**
     * 上一次登录ip
     */
    private String lastLoginIp;
    /**
     * 登录ip
     */
    private String currentLoginIp;
    /**
     * 当前用户可访问资源
     */
    private List<Resource> resources;
    /**
     * 当前用户对资源的操作权限
     */
    private List<Permission> permissions;
}
