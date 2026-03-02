package com.study.develop.service;

import tools.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.stream.Stream;

public class MapEx {

    private Map<String, Object> map;

    public MapEx(){
        this.map = new LinkedHashMap<>();
    }

    public MapEx(Map<String, Object> m){
        this();
        this.map = isInvaild(m) ? map : this.put(m).toMap();
    }

    public MapEx put(String k, Object o){
        this.map.put(k, o);
        return this;
    }

    public MapEx put(Map<String, Object> m){
        try {this.map.putAll(m);} catch (Exception e) {e.printStackTrace();}
        return this;
    }

    /*public MapEx put(List<Map<String, Object>> mList){
        return (isInvaild(mList)) ? this
                : this.put(mList.stream().collect(LinkedHashMap::new,(m, p) -> m.putAll(p), LinkedHashMap::putAll));
    }*/

    public boolean isInvaild() {
        return isInvaild(this.map);
    }


    public boolean isNull(Object o) {
        return o == null;
    }

    private boolean isInvaild(Object o) {
        return isNull(o) || "".equals(String.valueOf(o));
    }

    private boolean isInvaild(String ... s) {
        return Arrays.asList(s).stream().allMatch(p-> isInvaild(p));
    }

    private boolean isInvaild(Collection< ? > c ) {
        return isNull(c) || c.isEmpty();
    }

    public Map<String, Object> toMap(){
        return this.map;
    }

    public MapEx putObject(Object o){
        return isNull(o) ? this : objToMap(o);
    }

    public MapEx objToMap() {
        return objToMap(this.map);
    }

    @SuppressWarnings("unchecked")
    private MapEx objToMap(Object obj) {
        try {
            put(new ObjectMapper().convertValue(obj, Map.class));
        } catch (Exception e) {
            e.printStackTrace();
            this.map = new LinkedHashMap<>();
        }
        return this;
    }

    private Stream<Map.Entry<String,Object>> getStream(){
        return this.map.entrySet().stream();
    }

    public Object get(String k) {
        return this.map.get(k);
    }

    public Object getValueByKey(String k) {
        return objToMap().getValueByKey(this.map, k, clone());
    }

    public MapEx clone(){
        return new MapEx().put(this.map);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Object getValueByKey(Object o, String k, MapEx ex) {
        return isInvaild(o) || isInvaild(k) ? null
                : ((o instanceof Map)
                ? (new MapEx((Map) o).getStream()
                .peek(p -> ex.put(ex.toMap().containsKey(k) ? ex.put(k, ex.get(k)).toMap()
                        : ex.put(p.getKey(), p.getValue()).toMap()))
                .filter(p -> !k.equals(p.getKey())).map(p -> getValueByKey(p.getValue(), k , ex))
                .filter(vo -> !isNull(vo)).findAny().orElse(ex.get(k)))
                : ((o instanceof List)
                ? ((List) o).stream().map(p -> getValueByKey(p, k, ex)).filter(vo -> !isNull(vo)).findAny()
                .orElse(ex.get(k))
                : null));
    }

}
