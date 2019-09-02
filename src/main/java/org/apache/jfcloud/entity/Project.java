package org.apache.jfcloud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
@Setter
@Getter
@Entity
@Table(name = "JFCLOUD_PROJECT")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Project {
    @Id
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    @Column(columnDefinition="varchar(64) COMMENT 'ID'")
    private String id;
    @Column(columnDefinition="varchar(32) COMMENT '项目名称'")
    private String projectName;
    @Column(columnDefinition = "varchar(64) COMMENT '环境ID'")
    private String envId;
}
