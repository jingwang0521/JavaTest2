package com.hand;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class xmlThread implements Runnable {
	public void run() {
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
				System.out.println(s.toString());
				String s1 = s.toString();
				System.out.println(s1);
				String[] string = s1.split(",");
				System.out.println(string.length);

				String name = string[0];
				double open = Double.parseDouble(string[1]);
				double close = Double.parseDouble(string[2]);
				double current = Double.parseDouble(string[3]);
				double high = Double.parseDouble(string[4]);
				double low = Double.parseDouble(string[5]);
				//DOM
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.newDocument();
				Element root = document.createElement("socket");
				root.setAttribute("name", "it");

				root.setAttribute("open", "it");
				root.setAttribute("close", "it");
				root.setAttribute("current", "it");
				root.setAttribute("high", "it");
				root.setAttribute("low", "it");


				//-------------

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty("encoding", "UTF-8");

				StringWriter writer = new StringWriter();
				transformer.transform(new DOMSource(document), new StreamResult(writer));
				System.out.println(writer.toString());

				transformer.transform(new DOMSource(document), new StreamResult(new File("股票编码.xml")));
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}



