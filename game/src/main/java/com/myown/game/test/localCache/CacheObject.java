package com.myown.game.test.localCache;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CacheObject implements Comparable{

    //键
    private String key;
    //值
    private Object value;
    //创建时间
    private long storeTime;
    //过期时间
    private long expireTime;
    //最后一次访问时间
    private long accessTime;
    //几种次数
    private Integer hitCount;

    public CacheObject(String key, Object value, long storeTime, long expireTime, long accessTime,Integer hitCount) {
        this.key = key;
        this.value = value;
        this.storeTime = storeTime;
        this.expireTime = expireTime;
        this.accessTime = accessTime;
        this.hitCount = hitCount;
    }

    public CacheObject() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public long getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(long storeTime) {
        this.storeTime = storeTime;
    }

    public long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public long getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(long accessTime) {
        this.accessTime = accessTime;
    }

    @Override
    public int compareTo(Object cacheobject) {
        long hitcount = ((CacheObject) cacheobject).getHitCount().longValue();
        long hasLiveTime = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - ((CacheObject) cacheobject).getStoreTime());
        long perHitCount = hitcount/hasLiveTime;

        long hitCount1 = this.getHitCount().longValue();
        long hasLiveTime1 = TimeUnit.NANOSECONDS.toSeconds((System.nanoTime() - this.getStoreTime()));
        long perHitCount1 = hitCount1/hasLiveTime1;

        if(perHitCount>perHitCount1){
            return 0;
        }
        return 1;
    }
}
