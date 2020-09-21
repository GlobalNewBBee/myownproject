package com.myown.game.test.localCache;

import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public class CacheHelper {

    private static ConcurrentHashMap<String,CacheObject> cache = new ConcurrentHashMap(1024);

    //放入本地缓存
    public void put(String key,Object value,long expireTime){
        if(StringUtils.isBlank(key)){
            System.out.println("key不能为空！");
            return;
        }

        if(value==null){
            System.out.println("value不能为null");
            return;
        }
        //判断当前key是否是缓存中的key，如果是刷新值
        if(cache.containsKey(key)){
            CacheObject entry = cache.get(key);
            entry.setAccessTime(System.currentTimeMillis());
            entry.setHitCount(entry.getHitCount()+1);
            entry.setExpireTime(expireTime);
            entry.setStoreTime(System.currentTimeMillis());
            entry.setValue(value);
            return;
        }

        //判断当前缓存是否达到指定个数，如果是进行缓存淘汰
        if(isLimit()){
            //如果当前缓存个数已经超过了指定数量，记性淘汰
            String lruKey = getLRUKey();
            if(StringUtils.isBlank(lruKey)){
                return ;
            }else{
                cache.remove(lruKey);
            }
        }

        CacheObject object = new CacheObject();
        object.setKey(key);
        object.setValue(value);
        object.setStoreTime(System.currentTimeMillis());
        object.setExpireTime(expireTime);
        object.setHitCount(0);
        cache.put(key,object);
        return;
    }

    //获取本地缓存
    public Object getValue(String key){
        if(StringUtils.isBlank(key)){
            System.out.println("key不能为空串或者null");
            return null;
        }
        if(cache.isEmpty() || !cache.containsKey(key)){
            return null;
        }
        CacheObject object = cache.get(key);
        if(object==null){
            return null;
        }
        object.setHitCount(object.getHitCount()+1);
        object.setAccessTime(System.currentTimeMillis());
        cache.put(key,object);
        return object.getValue();
    }

    //缓存淘汰：当本地缓存中的缓存数量已经达到了一定的数量，就需要淘汰一些不经常使用来为新的缓存腾出空间
    //那么该怎么设计呢
    public boolean isLimit(){
        return true;
    }

    public String getLRUKey(){
        CacheObject min = (CacheObject) Collections.min(cache.values());
        return min.getKey();
    }
}
