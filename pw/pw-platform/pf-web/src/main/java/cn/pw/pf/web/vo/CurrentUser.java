package cn.pw.pf.web.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 当前登录用户
 *
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
    private String username;
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
     * 用户可登录系统（支持一个用户可以登录多个系统）
     */
    private List<SystemModel> currentModels;
    /**
     * 是否管理员
     */
    private boolean admin;
    /**
     * 是否开发者
     */
    private boolean developer;
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
     * 用户权限
     */
    private List<Permission> permissions;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        //系统角色
        if (admin) {
            auths.add(new SimpleGrantedAuthority("ADMIN_ROLE"));
        } else {
            auths.add(new SimpleGrantedAuthority("USER_ROLE"));
        }
        if (developer) {
            auths.add(new SimpleGrantedAuthority("DEVELOP_ROLE"));
        }
        //控制权限
        List<Permission> permissions = this.permissions;
        if (null == permissions || permissions.size() <= 0) {
            return auths;
        }
        for (Permission permission : permissions) {
            String resourceSign = permission.getResource().getSign();
            auths.add(new SimpleGrantedAuthority(resourceSign));
            List<Opration> oprations = permission.getOprations();
            if (null != oprations) {
                oprations.forEach(p -> {
                    auths.add(new SimpleGrantedAuthority(resourceSign + ":" + p));
                });
            }
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
