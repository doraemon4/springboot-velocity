package com.stephen.learning.model;

import lombok.Builder;
import lombok.Data;

/**
 * @Auther: jack
 * @Date: 2018/11/8 11:56
 * @Description:
 */
@Data
@Builder
public class User {
    private String name;
    private String sex;
    private int age;
    private String email;
}
