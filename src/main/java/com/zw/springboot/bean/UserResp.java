package com.zw.springboot.bean;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@Builder
public class UserResp {
    private String id;
    private String code;
    private String name;
    private String status;
}
