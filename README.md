仿照show-case的MVI架构，跟JsonChao的wanAndroid的MVP项目，以及hegaojian的jetPackMvvm-master改写一个基于kotlin，jetpack，组件化的MVI的项目  
View层：view/ViewModel/viewState  
Domain层：UseCase/DomainModel/Repository  
Data层：DataManager/Mapper/DataModel  

show-case是根据整洁架构的思想写的一个项目，看过不少整洁架构的文章，比较喜欢这种架构。  
喜欢的点：层级职责清楚，数据驱动，单元测试    
不喜欢的点：层级比较深  
wan-android是jsonchao基于java加当时流行的一些框架写的一个项目，同样是16年入行，jsonchao输出的东西非常全面且有深度，正好借鉴下他如何用他提到的那些技术写项目  
喜欢的点：AOP，监控，依赖抽象,多种动画  
不喜欢的点：单元测试很多没理解  

WanAndroid职能介绍  
Application：设置主题/初始化第三方库/插桩打印一些堆栈信息（图片/Binder/ClassLoader）/FPS监控/低内存时对Glide处理  
有趣的点：  
1 可能因为是demo所以没有异步加载/懒加载的一些东西，无法借鉴  
2 会把日志打印成文件保存在本地，是用开源库Logger实现的，可以借鉴  
3 会做全局的监控，可以借鉴  

TIPS：  
1 本来是想用BDD+TDD的方式写这个项目，但是不知道test包里只能找到对应包的类，如test里面的repository包，只能识别main里的repository包里面的类。模仿的项目里没有这个问题，知道的麻烦指导下，谢谢！
