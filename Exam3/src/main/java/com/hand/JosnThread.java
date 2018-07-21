package com.hand;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class JosnThread extends Thread{

	@Override
	public  void run(){

		String sb = new String("http://hq.sinajs.cn/list=");
		String concatUrl = sb.concat("sh601007");

		URL url;
		try {
			url = new URL("http://hq.sinajs.cn/list=sh601007");
			URLConnection conn = url.openConnection();
			conn.connect();
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Object s = httpConn.getContent();

				String s1= s.toString();
				String[] string=s1.split(",");

				String name=string[0];
				double open= Double.parseDouble(string[1]);
				double close=Double.parseDouble(string[2]);
				double current=Double.parseDouble(string[3]);
				double high=Double.parseDouble(string[4]);
				double low=Double.parseDouble(string[5]);

				JSONObject jsonObject=new JSONObject();
				jsonObject.put("name",name);
				jsonObject.put("open",open);
				jsonObject.put("close",close);
				jsonObject.put("current",current);
				jsonObject.put("high",high);
				jsonObject.put("low",low);



				FileInputStream fis=new FileInputStream(String.valueOf(jsonObject));
				BufferedInputStream bis=new BufferedInputStream(fis,100000);

				FileOutputStream fos=new FileOutputStream("../JavaTest2/Exam3/temp/股票编码.json");
				BufferedOutputStream bos=new BufferedOutputStream(fos,100000);

				byte[] byte1=new byte[100];

				if (bis.read(byte1)!=-1) {
					bos.write(byte1);
					bis.close();
					fis.close();
					bos.close();
					fos.close();
				}

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
}
