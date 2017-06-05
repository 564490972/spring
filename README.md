# spring
1、spring spring-mvc mybatis整合
整合注意点:
    1、数据库链接jndi
       (1)需要在tomcat的catalina.properties配置key=value值    jndiValue=java:comp/env/jndi/LCNEWS (jndi/LCNEWS为链接名字自己随便取，要去context.xml下的
       名字对应)
       (2)context.xml增加数据源如下:(根节点Context里面增加即可,注意增加数据库连接池的jar包)
       <Resource
        name="jndi/LCNEWS"
        factory="com.alibaba.druid.pool.DruidDataSourceFactory"
        auth="Container"
        type="javax.sql.DataSource"
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://127.0.0.1:3306/demo?useSSL=false"
        username="root"
        password="root"
        maxActive="50"
        maxWait="10000"
        removeabandoned="true"
        removeabandonedtimeout="60"
        logabandoned="false"
        filters="stat"/>
        <!--上面这两条一定要做-->
      2、pom.xml里面的<build>节点一定要有
