package com.oguzhansecgel.to_do_app.exception;

import java.util.Map;

public class ApiResponse<T> {
    private boolean success;
    private int status;
    private String message;
    private String error;
    private String path;
    private Map<String, Object> validationErrors;
    private T data;

    // Başarı yanıtı için constructor
    public ApiResponse(boolean success, String message, int status, T data, String path) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.data = data;
        this.path = path;
    }

    // Hata yanıtı için constructor
    public ApiResponse(boolean success, String message, int status, String error, String path, Map<String, Object> validationErrors) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.error = error;
        this.path = path;
        this.validationErrors = validationErrors;
    }

    // Getter ve Setter metodları
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, Object> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(Map<String, Object> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
