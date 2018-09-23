package cn.pw.pf.web.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session 操作工具类
 *
 * @author: libin
 * @date: 11:53 2018/9/21
 */
@Slf4j
public class SessionUtils {

    /**
     * return the HttpServletRequest currently bound to the thread.
     *
     * @return
     */
    public static HttpServletRequest currentRequest() {
        ServletRequestAttributes attrs =
                (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        return attrs.getRequest();
    }

    /**
     * return the HttpSession currently bound to the thread.
     *
     * @return
     */
    public static HttpSession currentSession() {
        HttpServletRequest req = currentRequest();
        HttpSession session = req.getSession();
        log.debug("session id: " + session.getId());
        return session;
    }

    /**
     * Binds an object to this session, using the name specified.
     * If an object of the same name is already bound to the session, the object is replaced
     *
     * @param name
     * @param value
     */
    public static void put(String name, Object value) {
        HttpSession session = currentSession();
        if (null == session) {
            return;
        }
        log.debug("put attribute: {}", name);
        try {
            session.setAttribute(name, value);
        } catch (Exception e) {
            log.warn(e.getMessage());
            log.warn("序列化异常", e);
            log.warn(Thread.getAllStackTraces().toString());
        }
    }

    /**
     * return the object bound with the specified name in session
     *
     * @param name
     * @return
     */
    public static Object get(String name) {
        HttpSession session = currentSession();
        if (null == session) {
            return null;
        }
        log.debug("get attribute: {}", name);
        try {
            return session.getAttribute(name);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        return null;
    }

    /**
     * remove the object bound with the specified name from the session
     *
     * @param name
     */
    public static void remove(String name) {
        HttpSession session = currentSession();
        if (null == session) {
            return;
        }
        log.debug("remove attribute: {}", name);
        try {
            session.removeAttribute(name);
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

    /**
     * Invalidates this session and unbinds any objects bound to it.
     */
    public static void invalidate() {
        HttpSession session = currentSession();
        if (session == null) {
            return;
        }
        try {
            session.invalidate();
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
    }

}
