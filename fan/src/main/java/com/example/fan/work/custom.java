package com.example.fan.work;

import java.util.List;

public class custom<T> {

    private String name;
    private T just;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public T getJust() {
        return just;
    }
    public void setJust(T just) {
        this.just = just;
    }
    @Override
    public String toString() {
        return "Order [name=" + name + ", just=" + just + "]";
    }

    //泛型方法的定义
    public <E> E getE(E e) {
        return e;
    }

    public <E> void fromArrayToList(E[] e , List<E> list) {
        for (E e1 : e) {
            list.add(e1);
        }
    }
}

class TSubOrder<T> extends custom<T> {

}

class IntSubOrder extends custom<Integer> {

}

   /* JsonArray array = new JsonParser().parse(json).getAsJsonArray();
    Gson gson = new Gson();
    Class<T> cls = null;
    Class clz = this.getClass();
    ParameterizedType type = (ParameterizedType) clz.getGenericSuperclass();
    Type[] types = type.getActualTypeArguments();
     cls = (Class<T>) types[0];
        for(final JsonElement elem : array){
        mList.add((T) gson.fromJson(elem, cls));
        }*/


