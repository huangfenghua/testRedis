import redis.clients.jedis.Jedis;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestRedis {
  public static void main(String[] args){

    /* Jedis jedis = new Jedis("127.0.0.1");
      jedis.auth("123456");

      //连接redis服务
     jedis.set("测试redis","hello redis");
      System.out.println("server is running :"+jedis.ping());
      System.out.println("Connection to server sucessfully");

      System.out.println(jedis.get("title"));*/

    RedisUtil redisUtil = new RedisUtil();
    redisUtil.setString("测试redis","hello redis");

    System.out.print("测试成功"+redisUtil.getString("测试redis"));
      /*RedisUtil redisUtil = new RedisUtil();
      String array[] = {"试试3","试试 2","试试1",};
      redisUtil.addSet("测试list",array);
      for (String sta:redisUtil.getList("测试list")
           ) {
        System.out.println("测试为"+sta);
      }*/




  }
}

