package com.soto.hadoop.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.json.JSONObject;

/**
 * 根据key找value
 */
public class KeyToValue extends UDF {
    public String evaluate(String av, String key) {
        if (av == null || key == null) {
            return "NULL";
        }

        //正常取值
        // sex=1&weight=129&height=180&sla=30000
        av = av.replaceAll("&", ",");
        av = av.replaceAll("=", ":");
        av = "{" + av + "}";
        System.out.println(av);
        //将符合json格式的av转换成json对象
        JSONObject jo = new JSONObject(av);


        return jo.get(key).toString();
    }

    public static void main(String[] args) {
        System.out.println(new KeyToValue().evaluate("sex=1&weight=129&height=180&sla=30000","sex"));
    }

}
