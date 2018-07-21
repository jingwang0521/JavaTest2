package com.hand;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Exam1 {

	public static void main(String[] args) {
		URL url;
		try {
			url = new URL("http://192.168.11.205:18080/trainning/SampleChapter1.pdf");
			URLConnection conn = url.openConnection();
			conn.connect();
			HttpURLConnection httpConn = (HttpURLConnection)conn;

			if(httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
				BufferedReader br = new BufferedReader(isr);

				FileOutputStream fos = new FileOutputStream("../JavaTest2/Exam1/temp/ampleChapter1.pdf");
				OutputStreamWriter bos = new OutputStreamWriter(fos);

				String str;

				if ((str=br.readLine())!=null) {
					bos.write(str);
				}
				br.close();
				isr.close();
				bos.close();
				fos.close();
				System.out.println("下载完成，已经保存");

			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}



