#### JPA继承QueryDsl  

###### 依赖  

```xml
<!--QueryDSL支持-->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-apt</artifactId>
            <scope>provided</scope>
        </dependency>
        <!--QueryDSL支持-->
        <dependency>
            <groupId>com.querydsl</groupId>
            <artifactId>querydsl-jpa</artifactId>
        </dependency>
```  

###### 生产query-type  

```xml
<!--
            生产query Type 插件配置
            查询实体，命名方式为："Q"+对应实体名
            -->
            <plugin>
                <groupId>com.mysema.maven</groupId>
                <artifactId>apt-maven-plugin</artifactId>
                <version>1.1.3</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>process</goal>
                        </goals>
                        <configuration>
                            <outputDirectory>target/generated-sources/java</outputDirectory>
                            <processor>com.querydsl.apt.jpa.JPAAnnotationProcessor</processor>
                        </configuration>
                    </execution>
                </executions>
            </plugin>  

<!--配置完插件后，在更新或者新建实体类后需要compile来更新QEntity-->
```    

###### JPA接入QueryDsl  

> 配置JPAQueryFactory  

```java
@Configuration
public class QueryDslConfig {

    @Autowired
    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory getJpaQueryDsl() {
        return new JPAQueryFactory(entityManager);
    }
}
```  

> repository案例  

```java
/**
*需继承JpaRepository和QuerydslPredicateExecutor。基础操作沿用JpaRepository,对于复杂查询可采用QueryDsl进行
*/
public interface MenuRepository extends JpaRepository<MenuEntity, Long> , QuerydslPredicateExecutor<MenuEntity> {
}
```    

###### queryDSL查询多列(单表多列或者连表多列)  

> 使用Tuple类型接收  

```java
List<Tuple> result = query.select(employee.firstName, employee.lastName)
                          .from(employee).fetch();
for (Tuple row : result) {
     System.out.println("firstName " + row.get(employee.firstName));
     System.out.println("lastName " + row.get(employee.lastName));
}}
```  

> 使用Bean population  

```java
List<UserDTO> dtos = query.select(
    Projections.bean(UserDTO.class, user.firstName, user.lastName)).fetch();
// When fields should be directly used instead of setters the following variant can be used instead

List<UserDTO> dtos = query.select(
    Projections.fields(UserDTO.class, user.firstName, user.lastName)).fetch();
```  

> 基于DTO构造函数填充结果  

```java
List<UserDTO> dtos = query.select(
    Projections.constructor(UserDTO.class, user.firstName, user.lastName)).fetch();
```  


[参阅](http://www.querydsl.com/static/querydsl/latest/reference/html/ch03s02.html)

> JPAQueryFactory和QueryDslPredicateExecutor两种支持方式  

参阅[模糊文档](https://www.jianshu.com/p/69dcb1b85bbb)
[文档](https://segmentfault.com/a/1190000020793740)



