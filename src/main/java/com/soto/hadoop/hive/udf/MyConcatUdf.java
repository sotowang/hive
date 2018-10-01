package com.soto.hadoop.hive.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

/**
 *inline ---> online_class
 */
public class MyConcatUdf extends UDF {
    public String evaluate(String word) {
        if (word == null) {
            return "NULL";
        }
        return word + "_class";
    }

    public static void main(String[] args) {
        System.out.println(new MyConcatUdf().evaluate("online"));
    }
}
