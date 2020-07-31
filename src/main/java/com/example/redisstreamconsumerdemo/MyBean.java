package com.example.redisstreamconsumerdemo;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@RedisHash("mybean")
@NoArgsConstructor
@AllArgsConstructor
public class MyBean implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    Long id;
    String name;
    String desc;
    double value;
    float percent;
    BigDecimal total;
}