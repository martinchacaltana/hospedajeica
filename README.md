crear archivo application.properties en la carpeta resources

spring.application.name=demo
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3307/nombredetubd?useSSL=false
spring.datasource.username=root
spring.datasource.password=tucontrasena
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver


spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl


spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
