package com.jf.utils.result;

import com.jf.common.meta.ResultCodeEnum;
import com.jf.utils.time.LocalDateTimeUtil;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 描述: 返回统一数据结构
 *
 * @author: 江峰
 * @create: 2021-03-19 17:22
 * @since: 2.20.1.1
 */
@Data
public class BaseResult<T> implements Serializable {

    private static final long serialVersionUID = -2893410163392884394L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 服务器当前时间
     */
    private String time = LocalDateTimeUtil
            .getLocalDateTimeStr(LocalDateTime.now());

    /**
     * 成功数据
     */
    private T data;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误描述
     */
    private String msg;

    /**
     * 成功返回，无数据
     */
    public BaseResult() {
    }

    /**
     * 成功返回，有数据
     *
     * @param data
     */
    private BaseResult(T data) {
        this.data = data;
        this.setResultCode(ResultCodeEnum.SUCCESS);
        this.setSuccess(Boolean.TRUE);
    }

    /**
     * 成功返回，有数据，自定义code和msg
     *
     * @param data
     * @param code
     * @param msg
     */
    private BaseResult(T data, Integer code, String msg, boolean success) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.success = success;
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(data);
    }

    public static <T> BaseResult<T> success(T data, Integer code) {
        return new BaseResult<T>(data, code, ResultCodeEnum.SUCCESS.message(), Boolean.TRUE);
    }

    public static <T> BaseResult<T> success(T data, String msg) {
        return new BaseResult<T>(data, ResultCodeEnum.SUCCESS.code(), msg, Boolean.TRUE);
    }

    public static <T> BaseResult<T> success(T data, Integer code, String msg) {
        return new BaseResult<T>(data, code, msg, Boolean.TRUE);
    }


    protected void setResultCode(ResultCodeEnum code) {
        this.code = code.code();
        this.msg = code.message();
    }

    /**
     * 失败返回,自定义 code和msg
     *
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult fail(Integer code, String msg) {
        BaseResult result = new BaseResult();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(Boolean.FALSE);
        return result;
    }

    /**
     * 失败返回,自定义 code
     *
     * @param code
     * @return
     */
    public static BaseResult fail(Integer code) {
        return fail(code, ResultCodeEnum.ERROR.message());
    }

    /**
     * 失败返回,自定义 code
     *
     * @param msg
     * @return
     */
    public BaseResult fail(String msg) {
        return fail(ResultCodeEnum.ERROR.code(), msg);
    }

    public boolean getSuccess() {
        return this.success;
    }

}