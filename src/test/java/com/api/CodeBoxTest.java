package com.api;

import com.api.core.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class CodeBoxTest {


    @Test
    public void testMysql(){
        log.info("可以");
        String s = HttpUtil.getInstance().httpPost("http://127.0.0.1:9999/workflow/list");
        System.out.println("报文=="+s);
    }

}
