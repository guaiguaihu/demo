package com.example.demo.util;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.domain.UserDomain;
import com.example.demo.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

import static com.example.demo.util.ClassUtils.setProperty;

/**
 * 操作信息工具类
 * 
 */
public class OperatorInfoUtil {

    private static Log logger = LogFactory.getLog(OperatorInfoUtil.class);

    private static String site;

    private static final UserDomain SYSTEM = new UserDomain();
    static {
        SYSTEM.setUsername("system");
    }

    public static final String addName = "addName", addNo = "addNo", addTime = "addTime", addSite = "addSite";
    public static final String updateName = "updateName", updateNo = "updateNo", updateTime = "updateTime",
            updateSite = "updateSite";
    public static final String checkName = "checkName", checkNo = "checkNo", checkTime = "checkTime";
    public static final String deleteName = "deleteName", deleteNo = "deleteNo", deleteTime = "deleteTime";
    public static final String operatorIp = "operatorIp";
    public static final String auditNo = "auditNo", auditName = "auditName", auditTime = "auditTime",
            allocateNo = "allocateNo", allocateName = "allocateName", allocateTime = "allocateTime";

    public static final String[] OPERATOR_INFO =
            new String[]{addNo, addName, addTime, updateNo, updateName, updateTime};

    public static final String[] OPERATOR_INFO_ALL = new String[]{addNo, addName, addTime, updateNo, updateName,
            updateTime, checkName, checkNo, checkTime};

    public static UserDomain getHttpSessionUser(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        if(servletRequestAttributes == null){
            return null;
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        return (UserDomain)request.getSession().getAttribute(WebSecurityConfig.SESSION_KEY);
    }

    /**
     * 填充添加人信息
     */
    public static final <T> T fillAddInfo(T entity) {
        return doFillInfo(entity, addName, addNo, addTime, addSite);
    }

    /**
     * 填充更新人信息
     */
    public static final <T> T fillUpdateInfo(T entity) {
        return doFillInfo(entity, updateName, null, updateTime, null);
    }

    /**
     * 填充更新人信息
     */
    public static final <T> T fillUpdateInfoWithChannelInfo(T entity) {
        try {
            setProperty(entity, "updateChannelType", null);
        }
        catch (Exception e) {
            logger.error("Fill updateChannelComId to null error:", e);
        }

        try {
            Method m = entity.getClass().getMethod("setUpdateChannelComId", Long.class);
            m.invoke(entity, new Object[]{null});
        }
        catch (Exception e) {
            // ignore
        }
        return doFillInfo(entity, updateName, updateNo, updateTime, updateSite);
    }

    /**
     * 填充添加人更新人信息
     */
    public static final <T> T fillOperateInfo(T entity) {
        Date now = new Date();
        doFillInfo(entity, addName, addNo, addTime, addSite, now);
        doFillInfo(entity, updateName, updateNo, updateTime, updateSite, now);
        return entity;
    }

    /**
     * 填充删除人信息
     */
    public static final <T> T fillDeleteInfo(T entity) {
        return doFillInfo(entity, deleteName, null, deleteTime, null);
    }

    /**
     * 填充审核人信息
     */
    public static final <T> T fillCheckInfo(T entity) {
        return doFillInfo(entity, checkName, checkNo, checkTime, null);
    }
    
    /**
     * 填充审核人信息
     */
    public static final <T> T fillAuditInfo(T entity) {
        return doFillInfo(entity, auditName, auditNo, auditTime, null);
    }

    /**
     * 填充分配人信息
     */
    public static final <T> T fillAllocateInfo(T entity) {
        Date now = new Date();
        doFillInfo(entity, allocateName, allocateNo, allocateTime, null, now);
        return entity;
    }

    /**
     * 获取登陆用户信息
     */
    public static UserDomain getOperateUser() {
        UserDomain user = getHttpSessionUser();
        return user == null ? SYSTEM : user;
    }

    /**
     * 填充指定信息
     * 
     * @param <T>
     * @param entity
     * @param name 操作人姓名对应的property名
     * @param no 操作人编号对应的property名
     * @param site 站点
     * @param time 操作时间对应的property名
     * @return
     */
    private static final <T> T doFillInfo(final T entity, String name, String no, String time, String site) {
        return doFillInfo(entity, name, no, time, site, new Date());
    }

    /**
     * 填充指定信息
     * 
     * @param <T>
     * @param entity
     * @param name 操作人姓名对应的property名
     * @param no 操作人编号对应的property名
     * @param time 操作时间对应的property名
     * @param site 站点
     * @param specificTime 指定填充的时间
     * @return
     */
    private static final <T> T doFillInfo(final T entity, String name, String no, String time, String site,
                                          Date specificTime) {
        try {
            UserDomain user = getOperateUser();
            setProperty(entity, name, user.getUsername());
//            setProperty(entity, no, user.getUsername());
            setProperty(entity, time, specificTime);
//            setProperty(entity, operatorIp, "127.0.001");
            if (site != null) {
//                setProperty(entity, site, getSite());
            }
            return entity;
        }
        catch (Exception e) {
            logger.error("Fill " + name + "," + no + "," + time + " to:" + entity + " error:", e);
        }
        return entity;
    }

    /**
     * 合并数组。这个方法本类常用到，所以加此工具
     * 
     * @param array1
     * @param array2
     * @return
     */
    public static final String[] addAll(String[] array1, String... array2) {
        String[] joinedArray = new String[array1.length + array2.length];
        System.arraycopy(array1, 0, joinedArray, 0, array1.length);
        System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
        return joinedArray;
    }

    public static String getSite() {
        return site;
    }

    /**
     * 此类无需实例化
     */
    private OperatorInfoUtil() {
    }

    /**
     * 获取默认系统用户
     * 
     * @return
     */
    public static UserDomain getSystemUser() {
        return SYSTEM;
    }
}
