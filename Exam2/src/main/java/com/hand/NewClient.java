package com.hand;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NewClient {
    public static void main(String [] arga){
        try {
            Socket s = new Socket("127.0.0.1",1001);

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine())!=null){
                sb.append(line);
            }
            br.close();

            File file = new File("../JavaTest2/Exam2/temp/ampleChapter1.pdf");

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            bw.write(sb.toString());
            bw.flush();
            bw.close();

        }catch(ConnectException connExc){
           
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
