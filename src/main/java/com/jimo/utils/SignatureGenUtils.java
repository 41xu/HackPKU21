package com.jimo.utils;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author algorithm
 */
public class SignatureGenUtils {

    /**
     * TreeMap对params name 排序
     * @param params
     * @return
     */
    public static String genSignatureWithParams(TreeMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        boolean first = true;
        for(String key: params.keySet()){
            key = UrlEncodeUtils.encodeUrl(key);
            String val = UrlEncodeUtils.encodeUrl(params.get(key));
            if(first){
                first = !first;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(key).append("=").append(val);
        }
        String s1 = stringBuilder.toString();
        String strToSign = "GET\\n/iaas/\\n" +s1;
        //String strToSign = "GET\\n/iaas/\\naccess_key_id=QYACCESSKEYIDEXAMPLE&action=RunInstances&count=1&image_id=centos64x86a&instance_name=demo&instance_type=small_b&login_mode=passwd&login_passwd=QingCloud20130712&signature_method=HmacSHA256&signature_version=1&time_stamp=2013-08-27T14%3A30%3A10Z&version=1&vxnets.1=vxnet-0&zone=pek3a";
        byte[] h = Sha256Utils.hash(strToSign.getBytes(StandardCharsets.UTF_8));
        String sign = Base64Utils.encode(Arrays.toString(h));
        return UrlEncodeUtils.encodeUrl(sign);
    }
}