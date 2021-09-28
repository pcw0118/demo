package com.example.demo.Service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    /** -------------------key相关操作--------------------- */

    

    /**
    * @Description:是否存在key
    * @Param:key
    * @return:Boolean
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public Boolean hasKey(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.hasKey(key);
    }


    /**
    * @Description:删除key
    * @Param:key
    * @return:Boolean
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public Boolean delete(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.delete(key);
    }

    
    /** 
    * @Description: 批量删除key 
    * @Param: keys 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long delete(Collection<String> keys){
        return redisTemplate.delete(keys);
    }
    
    
    /** 
    * @Description: 设置过期时间
    * @Param: [key, timeout, unit]
    * @return: Boolean
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Boolean expire(String key, long timeout, TimeUnit unit){
        if(null == key || null == unit){
            return false;
        }
        return redisTemplate.expire(key,timeout,unit);
    }

    
    /** 
    * @Description: 查找匹配的keys 
    * @Param: pattern 
    * @return: Set<String> 
    * @Author: 彭超
    * @Date: 2021/8/5
    */ 
    public Set<String> keys(String pattern){
        if(null == pattern){
            return null;
        }
        return redisTemplate.keys(pattern);
    }

    
    /** 
    * @Description: 移除key的过期时间 
    * @Param: key 
    * @return: Boolean
    * @Author: 彭超
    * @Date: 2021/8/5 
    */
    public Boolean persist(String key){
        if(null == key){
            return false;
        }
        return redisTemplate.persist(key);
    }


    /**
    * @Description: 获取key剩余的过期时间
    * @Param: [key, unit]
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public Long getExpire(String key, TimeUnit unit){
        if(null == key || null == unit){
            throw new RuntimeException("key or unit must not be null!");
        }
        return redisTemplate.getExpire(key,unit);
    }


    /**
    * @Description: 设置指定key的值
    * @Param: [key, value]
    * @return:
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public void set(String key, String value){
        if(null == key || null == value){
            return;
        }
        redisTemplate.opsForValue().set(key,value);
    }


    /**
    * @Description: 设置key的值并且设置过期时间
    * @Param: [key, value, time, unit]
    * @return:
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public void set(String key, String value, long time, TimeUnit unit){
        if(null == key || null == value ||  null ==unit){
            return;
        }
        redisTemplate.opsForValue().set(key, value, time, unit);
    }
    
    
    /** 
    * @Description: 设置key的时间以及过期时间，若是key存在，不做操作并返回false，否则设置值并且返回true 
    * @Param: [key, value, time, unit] 
    * @return: Boolean 
    * @Author: 彭超
    * @Date: 2021/8/5
    */ 
    public Boolean setifAbsen(String key, String value, long time, TimeUnit unit){
        if(null == key || null == value || null == unit){
            throw new RuntimeException("key, value and unit must not be null!");
        }
        return redisTemplate.opsForValue().setIfAbsent(key, value, time, unit);
    }

    
    /** 
    * @Description: 根据key获取对应的value值 
    * @Param: key 
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String get(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }


    /**
    * @Description: 先获取key对应的value值并将其设置成新的value
    * @Param: [key, value]
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public String getSet(String key, String value){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForValue().getAndSet(key, value);
    }


    /**
    * @Description: 批量获取key对应的value
    * @Param: keys
    * @return: List<String>
    * @Author: 彭超
    * @Date: 2021/8/5
    */
    public List<String> mget(Collection<String> keys){
        if(null == keys){
            return Collections.emptyList();
        }
        return redisTemplate.opsForValue().multiGet(keys);
    }

    
    /** 
    * @Description: 将指定key的value值原子性增加increment。若是key不存在，则初始值为0，增为increment。若是value值不能转换成increment，则抛出异常，操作成功则返回增加后的value值。
    * @Param: [key, increment]
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long incrby(String key, long increment){
        if(null == key){
            throw new RuntimeException("keyu不能为空");
        }
        return redisTemplate.opsForValue().increment(key, increment);
    }

    
    /** 
    * @Description: 将指定key的value原子性的减小decrement。若是该key不存在，则其初始值为0，在decrby之后值为-decrement。若是value不能转换成整数，则抛出异常。否则成功并且返回减少后的value值 
    * @Param: [key, decrement] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long decrby(String key, long decrement){
        if(null == key){
            throw new RuntimeException("key不能为空！");
        }
        return redisTemplate.opsForValue().decrement(key, decrement);
    }

    
    /** 
    * @Description: 若是key存在，则将参数value的值追加到key对应value值的末尾。若是不存在，创建一个新的key/value对，返回追加后的value字符串长度 
    * @Param: [key, value] 
    * @return: Integer
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Integer append(String key, String value){
        if(key == null){
            throw new RuntimeException("key不能为空!");
        }
        return redisTemplate.opsForValue().append(key, value);
    }

    
    /** 
    * @Description: 根据key以及field获取对应的value
    * @Param: [key, field]
    * @return: Object
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Object hget(String key, String field){
        if(null == key || null == field){
            return null;
        }
        return redisTemplate.opsForHash().get(key, field);
    }

    
    /** 
    * @Description: 为指定key设定field/value对，若是key不存在，则创建key并设置。若是field已经存在，则覆盖其值。结果返回1表示新的field设置值，0表示覆盖原有值 
    * @Param: [key, field, value]
    * @return:
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public void hset(String key, String field, String value){
        if(null == key || null == field){
            return;
        }
        redisTemplate.opsForHash().put(key, field, value);
    }

    
    /** 
    * @Description: 判断指定key的指定field是否存在，返回true表示存在，false表示field或者value不存在。 
    * @Param: [key, field] 
    * @return: [Boolean]
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Boolean hexists(String key, String field){
        if(null == key || null == field){
            return false;
        }
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    
    /** 
    * @Description: 从指定key的hash中删除多个字段，若是字段不存在则忽略，返回实际删除的字段数。若是key不存在，则视为空hash，并返回0 
    * @Param: [key, fields] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long hdel(String key, Object... fields){
        if(null == key || null == fields || fields.length == 0){
            return 0L;
        }
        return redisTemplate.opsForHash().delete(key, fields);
    }

    
    /** 
    * @Description: 根据key获取所有的field/value对 
    * @Param: key 
    * @return: Map<Object,Object>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Map<Object,Object> hgetall(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForHash().entries(key);
    }

    
    /** 
    * @Description: 对key所指的hash依次使用参数hash中的值设置field/value对。若是某个field存在，则进行覆盖。若是key不存在，则创建后进行操作。 
    * @Param: [key, hash]
    * @return:
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public void hmset(String key, Map<String,String> hash){
        if(null == key || null == hash){
            return;
        }
        redisTemplate.opsForHash().putAll(key, hash);
    }

    
    /** 
    * @Description: 获取key所指的hash中fields中所要求的field。顺序与fields中顺序一致，若是field不存在则返回null 
    * @Param: [key, fields] 
    * @return: List<Object>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public List<Object> hmget(String key, Collection<Object> fields){
        if(null == key || null == fields){
            return null;
        }
        return redisTemplate.opsForHash().multiGet(key, fields);
    }
    
    
    /** 
    * @Description: 给key对应hash中对应字段自增increment 
    * @Param: [key, field, incremenet] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long hIncrBy(String key, Object field, long increment){
        if(null == key || null == field){
            throw new RuntimeException("key以及field不能为空!");
        }
        return redisTemplate.opsForHash().increment(key, field, increment);
    }

    /***********************List数据类型***************************/
    
    
    /** 
    * @Description: 向列表左侧添加元素，若是key不存在，则创建一个空链表，再将数据从链表的头部插入。若是该key不是list类型，则会抛出异常。操作成功会返回插入后链表中元素的数量 
    * @Param: [key, strs] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long lpush(String key, String... strs){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForList().leftPushAll(key, strs);
    }

    
    /** 
    * @Description:
    * @Param:  
    * @return:  
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long rpush(String key, String... strs){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForList().rightPushAll(key, strs);
    }

    
    /** 
    * @Description: 返回指定key对应的链表中头部元素。若是key不存在，返回nil。 
    * @Param: key 
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String lpop(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForList().leftPop(key);
    }

    
    /** 
    * @Description: 弹出并返回key对应的链表中的最后一个元素。若是该key不存在，则返回nil 
    * @Param: key 
    * @return: String 
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String rpop(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForList().rightPop(key);
    }

    
    /** 
    * @Description: 返回key对应的链表中start至end范围内所有元素 
    * @Param: [key, start, end] 
    * @return: List<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public List<String> lrange(String key, long start, long end){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForList().range(key, start, end);
    }

    
    /** 
    * @Description: 对指定key对应的链表只保留start至end对应范围内的元素 
    * @Param: [key, start, end]
    * @return:
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public void ltrim(String key, long start, long end){
        if(null == key){
            return ;
        }
        redisTemplate.opsForList().trim(key, start, end);
    }

    
    /** 
    * @Description: 返回key对应链表中index位置的元素 
    * @Param: [key, index] 
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String lindex(String key, long index){
        if(null == key){
            return  null;
        }
        return redisTemplate.opsForList().index(key,index);
    }

    
    /** 
    * @Description: 返回对应key所指的链表中元素的数量 
    * @Param: key 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long llen(String key){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForList().size(key);
    }

    /****************************Set数据类型****************************************/
    
    /** 
    * @Description: 向key对应的set中插入元素，若是该元素存在，则忽略。 
    * @Param: [key, members] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long sadd(String key, String...  members){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForSet().add(key, members);
    }

    
    /** 
    * @Description: 返回key对应的set中成员数量，若是该set不存在，则返回0 
    * @Param: key 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long scard(String key){
        if(null == key){
            return  0L;
        }
        return redisTemplate.opsForSet().size(key);
    }

    
    /** 
    * @Description: 判断参数member是否存在于key对应的set集合中。返回true表示存在，返回false表示不存在。
    * @Param: [key, member]
    * @return: Boolean
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Boolean sismember(String key, String member){
        if(null == key){
            return false;
        }
        return redisTemplate.opsForSet().isMember(key, member);
    }

    
    /** 
    * @Description: 随机获取key所对应的set中一个成员，该命令不删除成员 
    * @Param: key 
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String srandmember(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForSet().randomMember(key);
    }

    
    /** 
    * @Description: 随机返回set中count个元素，若是count为正数且大于set中总元素个数，则只返回set中所有元素，若是count为负数且绝对值大于set中元素个数，则不够元素以重复元素补齐 
    * @Param: [key, count] 
    * @return: List<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public List<String> srandmember(String key, int count){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    
    /** 
    * @Description: 随机删除key对应set中一个元素并且返回该值 
    * @Param: key 
    * @return: String
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public String spop(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForSet().pop(key);
    }

    
    /** 
    * @Description: 通过key获取所有的成员
    * @Param: key
    * @return: Set<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> smembers(String key){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForSet().members(key);
    }

    
    /** 
    * @Description: 从key对应的set中删除参数members中所指定的所有元素，若是不存在对应元素，则忽略。 
    * @Param: [key, members] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long srem(String key, Object... members){
        if(null == key){
            return  0L;
        }
        return redisTemplate.opsForSet().remove(key, members);
    }

    
    /** 
    * @Description: 将元素从一个集合移到另一个集合 
    * @Param: [srckey, dstkey, member] 
    * @return: Boolean
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Boolean smove(String srckey, String dstkey, String member){
        if(null == srckey || null == dstkey){
            return false;
        }
        return redisTemplate.opsForSet().move(srckey, member, dstkey);
    }

    
    /** 
    * @Description: 获取两个集合的并集 
    * @Param: [key, otherkeys] 
    * @return: Set<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> sUnion(String key, String otherkeys){
        if(null == key || null == otherkeys){
            return null;
        }
        return redisTemplate.opsForSet().union(key,otherkeys);
    }



    /*****************************ZSet数据类型*********************************/
    
    /** 
    * @Description: 向key对应的ZSet中插入元素，按照score进行排序 
    * @Param: [key, score, member] 
    * @return: Boolean
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Boolean zadd(String key, double score, String member){
        if(null == key){
            return false;
        }
        return redisTemplate.opsForZSet().add(key, member, score);
    }

    
    /** 
    * @Description: 移除key对应的ZSet中指定的元素，不存在元素会被忽略 
    * @Param: [key, members] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long zrem(String key, Object... members){
        if(null == key || null == members){
            return 0L;
        }
        return redisTemplate.opsForZSet().remove(key, members);
    }

    
    /** 
    * @Description: 返回元素个数 
    * @Param: key 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long zcard(String key){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForZSet().size(key);
    }

    
    /** 
    * @Description: 为key中指定成员增加指定的分数
    * @Param: [key, score, member]
    * @return: Double
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Double zincrby(String key, double score, String member){
        if(null == key){
            throw new RuntimeException("key不能为空!");
        }
        return redisTemplate.opsForZSet().incrementScore(key, member, score);
    }

    
    /** 
    * @Description: 获取分数在min以及max之间的元素个数 
    * @Param: [key, min, max] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long zcount(String key, double min, double max){
        if(null == key){
            return 0L;
        }
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    
    /** 
    * @Description: 返回指定成员的位置值 
    * @Param: [key, member] 
    * @return: Long
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Long zrank(String key, String member){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().rank(key, member);
    }

    
    /** 
    * @Description: 返回指定元素分数，若是不存在，返回null 
    * @Param: [key, member]
    * @return: Double
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Double zscore(String key, String member){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().score(key, member);
    }

    
    /** 
    * @Description: 返回顺序在min和max之间的元素 
    * @Param: [key, min, max] 
    * @return: Set<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> zrange(String key, long min, long max){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().range(key, min, max);
    }

    
    /** 
    * @Description: 反向排序获取指定范围的元素 
    * @Param: [key, start, end] 
    * @return: Set<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> zReverseRange(String key, long start, long end){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    
    /** 
    * @Description: 返回在min和max闭区间之间的元素 
    * @Param: [key, min, max] 
    * @return: Set<String>
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> zrangeByScore(String key, double min, double max){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    
    /** 
    * @Description: 逆序获取分数在min和max闭区间之间的元素 
    * @Param: [key, min, max] 
    * @return: Set<String> 
    * @Author: 彭超
    * @Date: 2021/8/5 
    */ 
    public Set<String> zrevrangeByScore(String key, double min, double max){
        if(null == key){
            return null;
        }
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }
}
