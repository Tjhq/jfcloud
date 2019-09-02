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
@Table(name = "JFCLOUD_NODE")
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class Node {
    @Id
    @GeneratedValue(generator  = "myIdStrategy")
    @GenericGenerator(name = "myIdStrategy", strategy = "uuid")
    @Column(columnDefinition="varchar(64) COMMENT 'ID'")
    private String id;
    @Column(columnDefinition="varchar(32) COMMENT '节点名称'")
    private String hostname;
    @Column(columnDefinition="varchar(32) COMMENT '节点ip'")
    private String ip;
    @Column(columnDefinition = "varchar(64) COMMENT '系统'")
    private String os;
    @Column(columnDefinition = "varchar(64) COMMENT '用户名'")
    private String user;
    @Column(columnDefinition = "varchar(64) COMMENT '密码'")
    private String pwd;
    @Column(columnDefinition = "int(8) COMMENT '端口'")
    private int port;
    @Column(columnDefinition = "varchar(64) COMMENT '秘钥登录'")
    private String keyLogin;
    @Column(columnDefinition = "varchar(64) COMMENT '秘钥路径'")
    private String privateKey;
    @Column(columnDefinition = "varchar(64) COMMENT '秘钥密码'")
    private String passphrase;
    @Column(columnDefinition = "varchar(64) COMMENT '节点类型'")
    private String type;
    @Column(columnDefinition = "varchar(64) COMMENT '环境ID'")
    private String envId;

}
