package org.apache.jfcloud.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

/**
 * @author fxj
 * @date 2019/8/30 0030
 */
@Setter
@Getter
@Entity
@Table(name = "JFCLOUD_ENV")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Environment {
    @Id
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    @Column(columnDefinition="varchar(64) COMMENT 'ID'")
    private String id;
    @Column(columnDefinition="varchar(32) COMMENT '环境名称'")
    private String envName;
    @Column(columnDefinition="varchar(32) COMMENT '环境类型'")
    private String envType;

}
