package com.person.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author RootAdmin/RainbowPerfect
 * @version v1.0
 * @create 2019/12/11/22:54
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable {
    private Long deptno;
    private  String dname;
    private  String db_source;


}
