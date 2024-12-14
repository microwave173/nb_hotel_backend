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





```
获取所有空房间:
api/get_all_empty_rooms
method: GET
return: ["1", "2", "5", ...]

注册:
api/submit
method: POST
params: {"name": "Tom", "password": "123", "roomId": "1"}
return: "success" / "failed"

退房:
api/check_out
method: POST
params: {"roomId": "1"}
return: "success" / "failed"

获取自己房间信息:
api/get_my_room
method: GET
params: 无
return: {
	"roomId": "2",
	"du": 12,
	"cost": 137,
	"curTemperature": 15,
	"initTemperature": 15,
	"tarTemperature": 27,
	"tarTemperature1": 0,
	"acMode": 1,
	"status": 0,
	"cool": true
}
```

