package cn.com.cisdi.demo._base;


/**
 * 统一返回结果
 * @author Comup
 */
public class Result<T> {
    private static final String SUCCESS_STRING = "SUCCESS";
    private static final Integer SUCCESS_CODE = 0;
    private static final String ERROR_STRING = "ERROR";
    private static final Integer ERROR_CODE = -1;

    private Integer code;
    private T data;
    private String message;
    private String type;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Result() {
    }

    public Result(Integer code, T data, String message, String type) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.type = type;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setCode(SUCCESS_CODE);
        result.setMessage(SUCCESS_STRING);
        result.setType(data.getClass().getName());
        return result;
    }

    public static <T> Result<T> error(String message) {
        Result<T> result = new Result<T>();
        result.setCode(ERROR_CODE);
        result.setMessage(message);
        return result;
    }

    public static <T> Result<T> error(Integer errorCode, String message) {
        Result<T> result = new Result<T>();
        result.setCode(errorCode);
        result.setMessage(message);
        return result;
    }
}
