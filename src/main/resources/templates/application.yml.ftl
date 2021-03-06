# 端口
server:
  port: 8080

spring:
  application:
    name: ${projectMetadata.name}
<#if enableMybatisPlus>
  datasource:
    url: jdbc:mysql://${database.host}:${database.port}/${database.schema}?serverTimezone=Asia/Shanghai&characterEncoding=utf8&useSSL=false&zeroDateTimeBehavior=convertToNull
    username: ${database.username}
    password: ${database.password}
    driver-class-name: com.mysql.cj.jdbc.Driver
</#if>

happy:
  code:
    swagger:
      <#noparse>group: ${spring.application.name}</#noparse>
      base-package: ${projectMetadata.proPackage}
      title: ${projectMetadata.name}
      description: ${projectMetadata.description}
      version: 1.0
      contact:
        name: ${author.name}
        email: ${author.email}
      enable: true
