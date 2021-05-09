package com.jimo.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jimo.model.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
    public Result stopRds(@RequestParam(value = "id", required = false) String id) throws IOException, InterruptedException {
        if(id == null){
            return new Result(200, "did not stop any rds");
        }
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.qingcloud.com/iaas/?action=StopRDBs&rdbs.1="+id+"&zone=sh1b"))
                .build();
        JSONObject response = JSON.parseObject(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
        return new Result(200, "", response);
    }

}
