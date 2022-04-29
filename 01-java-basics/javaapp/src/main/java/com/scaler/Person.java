package com.scaler;


import lombok.*;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Getter
@Builder
@EqualsAndHashCode(of = {"name", "age"})
//@ToString
public class Person {
    private String name;
    private int age;
}
