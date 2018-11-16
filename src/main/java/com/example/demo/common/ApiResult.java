package com.example.demo.common;

import lombok.Data;

/**
 * Created by hmq on 2018/11/7.
 */

@Data
public class ApiResult {

    private Integer size;//每页显示条数

    private Integer page;//当前页

    private Long count;//总条数

    private Integer code;//状态码

    private String msg;//提示信息

    private Object data;//返回数据

}
