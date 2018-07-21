#!/bin/bash

echo "开始运行"
mvn clean package
for i in {1..3} 
do 
echo "--------------------------------"
echo "Exam${i}程序运行结果："
java -jar ./Exam${i}/target/Exam${i}.jar
done


