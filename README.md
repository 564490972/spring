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
      
=======================================================================================================================================
题外话和很例子关系不大
1、spring的根容器和spring-mvc容器是父子容器关系，子容器能看到父容器里面的bean，反之不能
父容器:WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
子容器:
      ServletContext servletContext = applicationContext.getServletContext();
      WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(servletContext,"org.springframework.web.servlet.FrameworkServlet.CONTEXT.DispatcherServlet");(---DispatcherServlet为自己配置控制器名字)
2、父子容器最好各司其职，父容器负责services，dao等bean的管理，子容器负责controller层bean管理，配置扫描的时候不要重复扫描了
3、如果按照上述2做了，需要注意自己手动加bean，要看清楚属于那一层的bean，一定要在相应容器内配置，不然自动获取不到。
