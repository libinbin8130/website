package cn.pw.pf.web.util;

import cn.pw.pf.web.vo.CurrentUser;

/**
 * 当前登录用户的会话信息
 * @author: libin
 * @date: 14:28 2018/9/21
 */
public class UserCurrentHome {

    public static final String CURRENT_USER_SESSION_NAME = "platform:session:user:";

    /**
     * 从session获取当前登录用户信息
     * @return
     */
    public static CurrentUser getUser(){
        return (CurrentUser)SessionUtils.get(CURRENT_USER_SESSION_NAME);
    }

    /**
     * 刷新当前登录用户信息到session
     * @param user
     */
    public static void updateUser(CurrentUser user){
        SessionUtils.put(CURRENT_USER_SESSION_NAME,user);
    }

    /**
     * 获取当前登录的用户名
     * @return
     */
    public static String currentUserName(){
        return null == getUser()? null : getUser().getUserName();
    }

    /**
     * 获取当前登录的用户真是姓名
     * @return
     */
    public static String currentRealName(){
        return null == getUser()? null : getUser().getRealName();
    }
}
