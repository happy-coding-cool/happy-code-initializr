# 端口
server:
  port: 8080
happy:
  boot:
    swagger:
      <#noparse>group: ${spring.application.name}</#noparse>
      base-package: ${projectMetadata.proPackage}
      title: ${projectMetadata.projectName}
      description: ${projectMetadata.description}
      version: 1.0
      contact:
        name: ${author.name}
        email: ${author.email}
      enable: true