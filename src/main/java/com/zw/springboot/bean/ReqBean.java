package com.zw.springboot.bean;

import com.zw.springboot.validata.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 数据校验
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqBean {
    @NotBlank(message = "code不能为空")
    @Length(min = 1 ,max = 20,message = "长度要在1到20之前")
    String code;
    @NotBlank(message = "code不能为空")
    @Length(max = 4,message = "名字最长4")
    String name;
    @Constant(message = "版本必须是1.0",value = "1.0")
    String version;
}
