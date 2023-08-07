package com.sangeng.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import com.alibaba.fastjson.parser.ParserConfig;
import org.springframework.util.Assert;
import java.nio.charset.Charset;

/**
 * Redis使用FastJson序列化
 * 
 * @author sg
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T>
{

    //定义了默认字符集为 UTF-8
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    //用于保存对象的类型信息
    private Class<T> clazz;

    //将全局的 ParserConfig 实例的自动类型支持设置为 true。
    //这将允许 Fastjson 在反序列化时使用 JSON 数据中的类信息来构造对象。
    static
    {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
    }

    //构造函数，接收一个 Class 对象，表示要序列化和反序列化的对象的类型
    public FastJsonRedisSerializer(Class<T> clazz)
    {
        super();
        this.clazz = clazz;
    }

    //将对象序列化成字节数组
    @Override
    public byte[] serialize(T t) throws SerializationException
    {
        if (t == null)
        {
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFAULT_CHARSET);
    }

    //将字节数组反序列化为对象
    @Override
    public T deserialize(byte[] bytes) throws SerializationException
    {
        if (bytes == null || bytes.length <= 0)
        {
            return null;
        }
        String str = new String(bytes, DEFAULT_CHARSET);

        return JSON.parseObject(str, clazz);
    }


    //用于获取对象的 JavaType
    protected JavaType getJavaType(Class<?> clazz)
    {
        return TypeFactory.defaultInstance().constructType(clazz);
    }
}