package com.zw.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
/*@Getter
@Setter*/
@AllArgsConstructor
public class CommonException extends Exception{
    private String msg;
    private String code;
}
