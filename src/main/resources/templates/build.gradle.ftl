apply plugin: "io.spring.dependency-management"
apply plugin: "java"

dependencyManagement {
    imports {
        mavenBom "cool.happycoding:happy-code-parent:${happyCodeVersion}"
    }
}

sourceCompatibility = ${projectMetadata.javaVersion}
targetCompatibility = ${projectMetadata.javaVersion}

compileJava {
    options.encoding = 'utf-8'
    options.define compilerArgs: [
    '-source', sourceCompatibility,
    '-target', targetCompatibility
    ]
}

group '${projectMetadata.group}'
version '0.0.1-SNAPSHOT'

jar{
    manifest {
    attributes "Implementation-Version": version
    }
}

repositories {
    mavenCentral()
}

dependencies {

    compile("cool.happycoding:happy-code-starter-web")
    compile("cool.happycoding:happy-code-starter-swagger")
    compile("cool.happycoding:happy-code-starter-user")
    compile("cool.happycoding:happy-code-starter-log")
<#if enableMybatisPlus>
    compile("cool.happycoding:happy-code-starter-mybatis")
</#if>
<#if enableJetCache>
    compile("cool.happycoding:happy-code-starter-cache")
</#if>
<#if enableRocketMQ>
    compile("cool.happycoding:happy-code-starter-mq")
</#if>

}
