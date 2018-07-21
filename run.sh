#!/bin/bash

echo "开始运行"
mvn clean package
for i in {1..3} 
do 
echo "--------------------------------"
echo "Exam${i}程序运行结果："
java -jar ./Exam${i}/target/Exam${i}.jar
done

echo "第二题，多个mian函数不会指定启动，但是可以打开代码启动"

