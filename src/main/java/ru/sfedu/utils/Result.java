package ru.sfedu.utils;

import ru.sfedu.model.enums.Response;

import java.util.List;
import java.util.Objects;

public class Result <T>{

    private List<T> list;
    private Response response;
    private String message;

    public Result(List<T> list, Response response, String message) {
        this.list = list;
        this.response = response;
        this.message = message;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;
        Result<?> result = (Result<?>) o;
        return getList().equals(result.getList()) && getResponse().equals(result.getResponse()) && getMessage().equals(result.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getList(), getResponse(), getMessage());
    }

    @Override
    public String toString() {
        return "Result{" +
                "list=" + list +
                ", response=" + response +
                ", message='" + message + '\'' +
                '}';
    }
}
