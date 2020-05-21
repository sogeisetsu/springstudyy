package org.suyuesheng.spring7.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ResultInfo {
    @Value("false")
    private boolean flag;

    private Object data;
    @Value("未知错误或者没有错误，Unknown error or no error")
    private String errorMsg;

    public ResultInfo() {
    }

    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", data=" + data +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
