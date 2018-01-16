package com.ktcd.malc.utilslibrary.tools;

/**
 * @author xiangbo
 * @version 1.0
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:16:21
 * @描述：字符串处理
 */
public class StringUtils {

    /**
     * @param string
     * @return
     * @description判断String是否为空,true代表空，false代表非空
     * @date 2015年8月19日
     */
    public static boolean isEmpty(String string) {
        if (string == null) {
            return true;
        } else if ("".equalsIgnoreCase(string.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 获取字符串最后一个字符
     **/
    public static String getOneCharacter(String string) {
        String str;
        if (string == null) {
            return " ";
        } else if ("".equalsIgnoreCase(string.trim())) {
            return " ";
        } else {
            str = string.substring(string.length() - 1, string.length());
        }
        return str;
    }

}
