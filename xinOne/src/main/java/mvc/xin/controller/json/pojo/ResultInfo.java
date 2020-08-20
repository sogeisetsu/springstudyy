package mvc.xin.controller.json.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ResultInfo {
    @Value("true")
    private boolean aBoolean;
    @Value(value = "成功")
    private String errorMsg;

    private Object data;

    public ResultInfo() {
    }

    public ResultInfo(boolean aBoolean,String errorMsg,Object data){
        this.aBoolean=aBoolean;
        this.errorMsg=errorMsg;
        this.data=data;
    }

    public boolean isaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String toString() {
        return "ResultInfo{" +
                "aBoolean=" + aBoolean +
                ", errorMsg='" + errorMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
