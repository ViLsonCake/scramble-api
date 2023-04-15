# Scramble generator API

This project is an API with random scramble generation according to the WCA standard.

Usage:
You need to send a GET request to url 

```/scramble?cube=CUBE_TYPE```

Cube types:
+ 2x2
+ 3x3
+ 4x4
+ 5x5
+ 6x6
+ 7x7
+ pyraminx

___

Dependencies:

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```
