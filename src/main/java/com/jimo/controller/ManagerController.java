package com.jimo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jimo.model.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * 运维接口
 *
 * @author algorithm
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {
    /**
     *   todo be param
     */
    public static String ACCESS_KEY_ID = "UYAVPRHPJIYRBWGPFCIK";
    /**
     * todo be param
     */
    public static String SECRET_ACCESS_KEY = "7TybgSeNlptBzo5Iy15PjkeLblNwBfNhD1h8HjxU";

    public static String METHOD = "HmacSHA256";

    public static String formatInstant(Instant instant) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .withZone(ZoneId.of("UTC"))
                .format(instant);
    }

    private static final String HEX = "0123456789ABCDEF";

    public static String encodeURIComponent(String str) {
        if (str == null) {
            return null;
        }

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        StringBuilder builder = new StringBuilder(bytes.length);

        for (byte c : bytes) {
            if (c >= 'a' ? c <= 'z' || c == '~' :
                    c >= 'A' ? c <= 'Z' || c == '_' :
                            c >= '0' ? c <= '9' : c == '-' || c == '.') {
                builder.append((char) c);
            } else {
                builder.append('%')
                        .append(HEX.charAt(c >> 4 & 0xf))
                        .append(HEX.charAt(c & 0xf));
            }
        }

        return builder.toString();
    }

    public static String createUrl(HashMap<String, String> args) throws Exception {
        // 1.  升序排列
        var list = new ArrayList<>(args.keySet());
        Collections.sort(list);

        // 2. 3. 边编码边生成querystring
        var sb = new StringBuilder();
        for (var key : list) {
            sb.append(encodeURIComponent(key));
            sb.append("=");
            sb.append(encodeURIComponent(args.get(key)));
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);

        // 4. 待签名串
        var signed = "GET\n/iaas/\n" + sb.toString();

        // 5. 签名
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_ACCESS_KEY.getBytes(StandardCharsets.UTF_8), METHOD);
        mac.init(secretKeySpec);
        var hmacSha256 = mac.doFinal(signed.getBytes(StandardCharsets.UTF_8));

        var base64 = Base64.getEncoder().encodeToString(hmacSha256);

        var urlEncoded = encodeURIComponent(base64);

        // 6. 装在请求串最后面
        sb.append("&signature=").append(urlEncoded);

        // 7. url
        var url = "https://api.qingcloud.com/iaas/?" + sb.toString();

        return url;
    }


    @GetMapping("/stop/cl")
    public Result stopCl() throws Exception {

        var requestArgs = new HashMap<String, String>();

        requestArgs.put("action", "StopClusters");
        requestArgs.put("clusters.1", "cl-x82wzm1w");
        requestArgs.put("zone", "sh1a");

        var now = Instant.now();

        requestArgs.put("time_stamp", formatInstant(now));

        requestArgs.put("access_key_id", ACCESS_KEY_ID);
        requestArgs.put("version", "1");
        requestArgs.put("signature_version", "1");
        requestArgs.put("signature_method", METHOD);

        var url = createUrl(requestArgs);

        // 8. call
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        JSONObject response = JSON.parseObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        return new Result(200, "", response);
    }


    /**
     * todo appId和appSecret 通过salt 加密成为encodedStr
     * todo 传进来 salt和encodedStr 我们这边解密得到appId和appSecret
     *
     * @param appId
     * @param appSecret
     * @param clusterId
     * @param zone
     * @return
     * @throws Exception
     */
    @GetMapping("/stop/cl/v2")
    public Result stopClV2(@RequestParam(value = "appId", required = true) String appId,
                          @RequestParam(value = "appSecret", required = true) String appSecret,
                          @RequestParam(value = "clusterId", required = true) String clusterId,
                          @RequestParam(value = "zone", required = true) String zone) throws Exception {
        ACCESS_KEY_ID = appId;
        SECRET_ACCESS_KEY = appSecret;

        var requestArgs = new HashMap<String, String>();

        requestArgs.put("action", "StopClusters");
        requestArgs.put("clusters.1", clusterId);
        requestArgs.put("zone", zone);

        var now = Instant.now();

        requestArgs.put("time_stamp", formatInstant(now));

        requestArgs.put("access_key_id", ACCESS_KEY_ID);
        requestArgs.put("version", "1");
        requestArgs.put("signature_version", "1");
        requestArgs.put("signature_method", METHOD);

        var url = createUrl(requestArgs);

        // 8. call
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        JSONObject response = JSON.parseObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        return new Result(200, "", response);
    }

}
