package com.bis.myjavaxmlapitest.network;

public class ResponseState<T> {
    private Status status;
    private T data;
    private String message;

    public enum Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    public ResponseState(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static <T> ResponseState<T> success(T data) {
        return new ResponseState<T>(Status.SUCCESS, data, null);
    }

    public static <T> ResponseState<T> error(String message) {
        return new ResponseState<>(Status.ERROR, null, message);
    }

    public static <T> ResponseState<T> loading() {
        return new ResponseState<>(Status.LOADING, null, null);
    }
}
