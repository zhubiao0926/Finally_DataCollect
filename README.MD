# 项目第一天

### 1.修改版

###### **1.1添加了Util的WossModulelnit（模块化）接口
###### 1.2Bean包下的Environment中的属性gather_time的类型由Date变为TimeStamp。
###### 1.3修改接口改为抛出异常。一般在逻辑层都是抛出异常。
###### 1.4改gather()方法中的BufferReader为RandomAccessFile流（可读可写）
```java**
	RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/java/radwtmp", "r");
```

###### **1.5将变量提取到循环之外，节约栈区内存**
2.修改了日志模块。可用构造器加载日志配置。

项目第一天CSDN社区博客：https://blog.csdn.net/weixin_44468294/article/details/106782591

项目第四天CSDN社区博客：https://blog.csdn.net/weixin_44468294/article/details/106878813

项目第五天CSDN社区博客：https://blog.csdn.net/weixin_44468294/article/details/106880354
