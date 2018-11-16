package com.example.demo.model;

import com.example.demo.common.SaveGroup;
import com.example.demo.common.UpdateGroup;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by hmq on 2018/11/13.
 */

@Data
@Table(name="t_team") //设置数据库中表名
public class Team implements Serializable{
    @Id
    @NotNull(message = "Id不能为空",groups = {UpdateGroup.class})
    private Integer id;
    @NotNull(message = "name不能为空",groups = {SaveGroup.class})
    private String name;

    private String coach;//教练
//    @Column(name="create_date")
//    private Date createDate;

    private String rank;//排名

    private String region;//地区
}
