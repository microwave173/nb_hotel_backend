### 食用方法

使用idea的话，打开pom.xml，然后右面的一栏有个m，点开后点击lifecycle下的install，下载完依赖后点击上面的循环箭头图标（卡的话可以关掉再打开），然后修改src/main/resources/application.properties，主要是改”ac_data“ 和 mysql的用户名和密码

```
spring.datasource.url=jdbc:mysql://localhost:3306/ac_data?useSSL=false&characterEncoding=utf8&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=18840607723ma
```

在名为ac_data的数据库下运行init.sql初始化数据库

运行Ac....tion就可以启动

python测试脚本，直接运行test.py
