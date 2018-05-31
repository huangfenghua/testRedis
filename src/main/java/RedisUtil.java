import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUtil {

    //Redis服务器IP
    private static String ADDR = "127.0.0.1";

    //Redis的端口号
    private static int PORT = 6379;

    //访问密码
    private static String AUTH = "123456";

    private static  Jedis jedis ;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            // 连接本地的 Redis 服务
            jedis = new Jedis("127.0.0.1");
            jedis.auth("123456");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setString(String key, String value, int expire) {

        jedis.set(key, value);
        jedis.expire(key, expire);
        if (jedis != null) {
            jedis.close();
        }
    }

    public void setString(String key, String value) {
        jedis.set(key, value);
        if (jedis != null) {
            jedis.close();
        }
    }

    public String getString(String key) {
        String value = jedis.get(key);
        if (jedis != null) {
            jedis.close();
        }
        return value;
    }


    // 检查给定 key 是否存在。
    public boolean existsKey(String key) {
        boolean result = jedis.exists(key);
        if (jedis != null) {
            jedis.close();
        }
        return result;
    }


    // 向集合添加一个或多个成员
    public Long addSet(String key, String... member) {
        Long sadd = jedis.sadd(key, member);
        if (jedis != null) {
            jedis.close();
        }
        return sadd;
    }


    // 获取list所有元素
    public List<String> getList(String key) {
        Integer startIndex = 0;
        Integer endIndex = -1;// 获取所有
        List<String> list = jedis.lrange(key, startIndex, endIndex);

        if (jedis != null) {
            jedis.close();
        }
        return list;
    }


    // 移除集合中一个或多个成员
    public Long remSet(String key, String... member) {
        Long srem = jedis.srem(key, member);
        if (jedis != null) {
            jedis.close();
        }
        return srem;
    }


    // 获取集合成员数
    public long getSCard(String key) {
        long result = jedis.scard(key);
        if (jedis != null) {
            jedis.close();
        }
        return result;
    }



}




