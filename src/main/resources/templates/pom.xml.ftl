<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>cool.happycoding</groupId>
        <artifactId>happy-code-parent</artifactId>
        <version>${happyCodeVersion}</version>
    </parent>

    <groupId>${projectMetadata.group}</groupId>
    <artifactId>${projectMetadata.artifact}</artifactId>
    <version>0.0.1-SNAPSHOT</version>

    <name>${projectMetadata.name}</name>
    <description>${projectMetadata.description}</description>

    <properties>
        <maven.compiler.source>${projectMetadata.javaVersion}</maven.compiler.source>
        <maven.compiler.target>${projectMetadata.javaVersion}</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-swagger</artifactId>
        </dependency>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-user</artifactId>
        </dependency>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-log</artifactId>
        </dependency>
        <#if enableMybatisPlus>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-mybatis</artifactId>
        </dependency>
        </#if>
        <#if enableJetCache>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-cache</artifactId>
        </dependency>
        </#if>
        <#if enableRocketMQ>
        <dependency>
            <groupId>cool.happycoding</groupId>
            <artifactId>happy-code-starter-mq</artifactId>
        </dependency>
        </#if>
    </dependencies>
    <build>
        <#noparse><finalName>${project.artifactId}</finalName></#noparse>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
