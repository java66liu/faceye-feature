faceye-feature
==============
          
      开始之前：
      1.配置${ANT_HOME},${M2_HOME}
      2.下载ant-contrib 放置至:${ANT_HOME}/lib
      
      FaceYe 项目自助化工具
      解决问题:解决项目初期搭建调试与集成耗时现像
      项目模板包括:
      1.Web前端.
      2.管理后台.
      3.移动服务端.
      4.android(todo).
      5.ios(todo)
      相关技术:
      1.spring mvc
      2.tiles,jstl,bootstrap,jQuery.
      3.spring-data-jpa
      4.spring-data-redis
      5.spring-data-mongo
      6.hibernate
      7.maven`
      8.ant
      Github:https://github.com/haipenge/faceye-feature.git
      		
      与作者联系
      Author:@haipenge
      Email:haipenge@gmail.com
      
      		

     help:
      1.创建一个新项目: generate-project
      2.创建一个模块:   generate-component
      3.创建实体    :  generate-entity-source
        同时创建:Repository,Service,Controller,Jsp form,js, css
      4.为实体增加属性: generate-entity-property
      5.修改模板:修改src/template/source 下的模板类
      6.删除一个实体:  remove-entity-source
      7.删除一个模块:  remove-component
      
      常用任务：
      1.创建一个新项目：
      ant -f build-tools.xml generate-project
      2.创建一个模块：
      ant -f build-tools.xml generate-component
      3.创建一个新的实体对像：
      ant -f build-tools.xml generate-entity-source
      4.为一个实体增加属性
      ant -f build-tools.xml generate-entity-property
      
      5.修改数据库链接
       src/main/filters/*.properties
       dev->开发
       test-> 测试
       product ->生产
       
      6.打包：
       测试包：mvn clean compile war:war -P test -Dmaven.test.skip=true
       生长包: mvn clean compile war:war -P product -Dmaven.test.skip=true
      
