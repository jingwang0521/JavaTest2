package com.hand;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.println("请输入股票代码：");
		String str = in.next();
		String url = "http://hq.sinajs.cn/list=" + str;
		System.out.println("股票编码:" + str);

		try {
			URL u2 = new URL(url);
			URLConnection conn = u2.openConnection();
			conn.connect();
			HttpURLConnection httpConn = (HttpURLConnection) conn;

			if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				Object s = httpConn.getContent();

				String s1 = s.toString();

				String[] string = s1.split(",");

				JosnThread j1 = new JosnThread();
				xmlThread x = new xmlThread();
				Thread x1 = new Thread(x);
				j1.start();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}