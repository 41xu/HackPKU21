package com.jimo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jimo.model.common.Result;
import com.jimo.utils.MyConsts;
import com.jimo.utils.SignatureGenUtils;
import com.jimo.utils.TimeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;
import java.util.TreeMap;

/**
 * 运维接口
 *
 * @author algorithm
 * @href https://docsv3.qingcloud.com/development_docs/api/command_list/rdb/stop_rdbs/
 */
@RestController
@RequestMapping("/rds")
public class ManagerController {
    /**
     * todo jwt鉴权
     *
     * @return
     */
    @GetMapping("/stop")
    public Result stopRds(@RequestParam(value = "order", required = false) String order)
            throws IOException, InterruptedException {
        if (order == null) {
            return new Result(200, "invalid request");
        }
        TreeMap<String, String> params = new TreeMap<>();
        params.put("access_key_id", MyConsts.ACCESS_KEY_ID);
        params.put("action", "StopRDBs");
        params.put("clusters.n", MyConsts.CL_ID);
        params.put("signature_method", MyConsts.API_SIGNATURE_METHOD);
        params.put("signature_version", MyConsts.API_SIGNATURE_VERSION);
        params.put("time_stamp", TimeUtils.getISO8601Timestamp(new Date()));
        params.put("version", MyConsts.API_VERSION);
        params.put("zone", MyConsts.RDB_ZONE);
        String signature = SignatureGenUtils.genSignatureWithParams(params);
        System.out.println("signature " + signature);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest.Builder builder = HttpRequest.newBuilder();
        for(String key: params.keySet()){
            builder.setHeader(key, params.get(key));
        }
        builder.setHeader("signature", signature);
        HttpRequest request = builder.uri(URI.create("https://api.qingcloud.com/iaas/")).build();
        JSONObject response = JSON.parseObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        return new Result(200, "", response);
    }

}
