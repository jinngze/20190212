package com.example.a20190216.di.presneter;

import java.util.Map;

public interface IPresent {
    void  onRequest(String url, Map<String, String> params, Class clazz);
}
