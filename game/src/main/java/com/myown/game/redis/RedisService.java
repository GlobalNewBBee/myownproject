package com.myown.game.redis;

import com.myown.game.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /*-------common-------*/

    /*
    * 指定缓存失效时间
    * */
    public boolean expire(String key,long time){
        try{
            Boolean expire = redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return expire;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /*
    * 获取这个key的过期时间
    * */
    public Long getExpire(String key){
        Long expireTime = redisTemplate.getExpire(key,TimeUnit.SECONDS);
        return expireTime;
    }

    /*
    * 判断这个key是否存在
    * */
    public boolean hasKey(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    /*
    * 删除缓存
    * */
    public void del(String... keys){
        if(keys!=null && keys.length>0){
            if(keys.length==1){
                redisTemplate.delete(keys[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(keys));
            }
        }
    }

    /*-------Hash--------*/
    public void hset(String key,Object value){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put(Constants.Hash_key,key,value);
    }

    public Object hget(String key){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object value = hashOperations.get(Constants.Hash_key, key);
        return value;
    }

    /*
    * 设置这个key的多个键值对
    * */
    public void hmset(Map map){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.putAll(Constants.Hash_key,map);
    }

    public List hmget(Collection collection){
        HashOperations hashOperations = redisTemplate.opsForHash();
        List list = hashOperations.multiGet(Constants.Hash_key, collection);
        return list;
    }

    /*
    * 获取key的所有的键值对
    * */
    public Map<String,Object> hentries(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Map entries = hashOperations.entries(Constants.Hash_key);
        return entries;
    }


}
