package org.apache.jfcloud.configure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author fxj
 * @date 2019/8/25 0025
 */
@Setter
@Getter
@ToString
public class ParseData<E> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 处理成功的状态常量
     */
    private static final Integer SUCCESS = 200;

    /**
     * 处理错误时的状态常量
     */
    private static final Integer FAIL = 500;
    /**
     * 处理错误时的信息常量
     */
    private static final String FAIL_MESSAGE = "处理失败";
    /**
     * 处理成功时的错误信息常量
     */
    private static final String SUCCESS_MESSAGE = "处理成功";
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 必要的提示信息
     */
    private String msg;

    /**
     * 数据条数
     */
    private long count = 0;
    /**
     * 业务数据
     */
    private E data;

    /**
     * 缺省构造
     */
    public ParseData() {}
    /**
     * 用于设置业务数据构造方法
     * @param data 数据
     */
    public ParseData(E data) {
        this.data = data;
    }
    /**
     * 用于设置状态、错误信息、业务数据的构造方法
     * @param code 编码
     * @param msg  消息
     * @param data 数据
     */
    public ParseData(Integer code, String msg, E data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    /**
     * 处理成功方法
     * staus=200 成功信息为默认的成功信息"处理成功"
     * @return 成功OutputData对象
     */
    public ParseData returnSuccess(){
        this.code = SUCCESS;
        if(this.msg==null){
            this.msg= SUCCESS_MESSAGE;
        }
        return this;
    }
    /**
     *
     * 处理成功方法
     * code=200 成功信息为入参message
     * @param data 成功数据
     * @return 成功OutputData对象
     */
    public ParseData returnSuccess(E data){
        this.code = SUCCESS;
        this.msg= SUCCESS_MESSAGE;
        this.data=data;
        return this;
    }

    /**
     *
     * 处理成功方法
     * code=200 成功信息为入参message
     * @param msg 成功信息
     * @param data 成功数据
     * @return 成功OutputData对象
     */
    public ParseData returnSuccess(E data,String msg){
        this.code = SUCCESS;
        this.data=data;
        this.msg= msg;
        return this;
    }
    /**
     * 处理失败的方法
     * code=500 失败信息为默认信息“处理失败”
     * @return 失败OutputData对象
     */
    public ParseData returnFail(){
        this.code = FAIL;
        if(this.msg==null){
            this.msg=FAIL_MESSAGE;
        }
        return this;
    }

    /**
     * 处理失败的方法
     * code=500 失败信息传入的失败信息
     * @param msg 失败信息
     * @return 失败OutputData对象
     */
    public ParseData returnFail(String msg){
        this.code = FAIL;
        this.msg=msg;
        return this;
    }

    /**
     * 处理失败的方法
     * code=500 失败信息传入的失败信息
     * @param msg 失败信息
     * @param data 失败数据
     * @return 失败OutputData对象
     */
    public ParseData returnFail(E data,String msg){
        this.code = FAIL;
        this.data=data;
        this.msg=msg;
        return this;
    }
}
