package com.jimo.utils;

/**
 * @author algorithm
 */
public interface MyConsts {
    /**
     * 分页默认大小
     */
    int DEFAULT_PAGE_SIZE = 10;
    /**
     * 默认起始页数
     */
    int DEFAULT_PAGE_BEGIN = 1;

    /**
     * 申请的 API密钥ID，例如”QYACCESSKEYIDEXAMPLE”。
     * todo 申请API 密钥
     */
    String ACCESS_KEY_ID  = "UYAVPRHPJIYRBWGPFCIK";

    /**
     *API的版本号，目前只支持版本号为 1。
     */
    String API_VERSION = "1";
    /**
     * 签名所用哈希算法，目前支持 HmacSHA256 和 HmacSHA1。
     */
    String API_SIGNATURE_METHOD = "HmacSHA256";
    /**
     * 签名函数的版本号，目前只支持版本号为 1。
     */
    String API_SIGNATURE_VERSION = "1";

    String CL_ID = "cl-x82wzm1w";
    String RDB_ZONE = "sh1a";


}
