package com.fish.tool;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;

public class JsonUtil {

    private static Gson gson;
    private static Gson gsonTime;

    static {
        gson = new Gson();
        gsonTime = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws   JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        }).create();
    }

    private JsonUtil() {
    }

    /**
     * 将json通过类型转换成对象
     * <p/>
     * <pre>
     *     {@link JsonUtil JsonUtil}.fromJson("{\"username\":\"username\", \"password\":\"password\"}", User.class);
     * </pre>
     *
     * @param json  json字符串
     * @param clazz 泛型类型
     * @return 返回对象
     * @throws
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return (T)gson.fromJson(json,clazz);
    }

    /**
     * 将json通过类型转换成对象
     * <p/>
     * <pre>
     *     {@link JsonUtil JsonUtil}.fromJsonTime("{\"username\":\"username\", \"password\":\"password\"}", User.class);
     * </pre>
     *
     * @param json  json字符串
     * @param clazz 泛型类型
     * @return 返回对象
     * @throws
     */
    public static <T> T fromJsonTime(String json, Class<T> clazz) {
        return (T)gsonTime.fromJson(json,clazz);
    }

    /**
     * 将对象转换成json
     * <p/>
     * <pre>
     *     {@link JsonUtil JsonUtil}.toJson(user);
     * </pre>
     *
     * @param src 对象
     * @return 返回json字符串
     * @throws
     */
    public static <T> String toJson(T src) {
        return gson.toJson(src);
    }


    /**
     * 将jsonElement转为jsonObject
     * @param jsonElement
     * @return
     */
    public static JsonObject getJsonObject(JsonElement jsonElement) {
        return getJsonObject(jsonElement.getAsString());
    }

    /**
     * 将json字符串转为jsonObject
     * @param jsonStr
     * @return
     */
    public static JsonObject getJsonObject(String jsonStr) {
        return new JsonParser().parse(jsonStr).getAsJsonObject();
    }

    /**
     * 将jsonElement转为jsonArray
     * @param jsonElement
     * @return
     */
    public static JsonArray getJsonArray(JsonElement jsonElement) {
        return getJsonArray(jsonElement.getAsString());
    }

    /**
     * 将json字符串转为jsonArray
     * @param jsonStr
     * @return
     */
    public static JsonArray getJsonArray(String jsonStr) {
        return new JsonParser().parse(jsonStr).getAsJsonArray();
    }

    /**
     * 将json通过类型转换成对象
     * <p/>
     * <pre>
     *     {@link JsonUtil JsonUtil}.fromJsonByGoogle("[{\"username\":\"username\", \"password\":\"password\"}, {\"username\":\"username\", \"password\":\"password\"}]", new TypeToken&lt;List&lt;User&gt;&gt;() {});
     * </pre>
     *
     * @param json json字符串
     * @param typeToken 引用类型
     * @return 返回对象
     * @see com.google.gson.Gson
     */
    public static <T> T fromJson(String json, TypeToken<?> typeToken) {
        return (T)gson.fromJson(json, typeToken.getType());
    }

    /**
     * 将json数组转换为List
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonToList(String json, Class clazz) {
        return gson.fromJson(json, new ParameterizedTypeImpl(clazz));
    }

    private static class ParameterizedTypeImpl implements ParameterizedType {
        Class clazz;

        ParameterizedTypeImpl(Class clz) {
            clazz = clz;
        }

        @Override
        public Type[] getActualTypeArguments() {
            return new Type[]{clazz};
        }

        @Override
        public Type getRawType() {
            return List.class;
        }

        @Override
        public Type getOwnerType() {
            return null;
        }
    }

}
