package com.example.redisstreamconsumerdemo;

import java.io.ByteArrayOutputStream;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.util.Pool;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class KryoSerializer<T> implements RedisSerializer<T> {

    private Class<T> claz;
    private Pool<Kryo> kryoPool;

    public KryoSerializer(Class<T> claz, Pool<Kryo> pool) {
        this.claz = claz;
        this.kryoPool = pool;
    }

    @Override
    public byte[] serialize(T bean) throws SerializationException {
        System.out.println("serializing");
        Kryo kryo = kryoPool.obtain();
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            Output output = new Output(outputStream);
            kryo.writeClassAndObject(output, bean);
            return outputStream.toByteArray();
        } finally {
            kryoPool.free(kryo);
        }
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        System.out.println("deserializing");
        Kryo kryo = kryoPool.obtain();
        try {
            Input input = new Input(bytes);
            return (T) kryo.readClassAndObject(input);
        } finally {
            kryoPool.free(kryo);
        }
    }

}