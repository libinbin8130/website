package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 当前登录用户
 * @author: libin
 * @date: 14:34 2018/9/21
 */
@Getter
@Setter
@ToString
public class CurrentUser implements UserDetails {

    /**
     * 当前用户id
     */
    private Long id;
    /**
     * 当前用户登录名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;
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
     * 当前用户操作权限
     */
    private List<Permission> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //对资源(菜单)的控制
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        List<Resource> resources = this.resources;
        //对操作(按钮)的控制
        List<Permission> permissions = this.permissions;
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
