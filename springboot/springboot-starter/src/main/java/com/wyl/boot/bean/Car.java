package com.wyl.boot.bean;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @auther yanl.wang
 * @date 2023/2/21
 **/

//@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@ConfigurationProperties(prefix = "mycar")
public class Car {
    private Integer price;
    private String brand;

}
