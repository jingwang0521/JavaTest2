package com.hand;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NewServer {
    public static void main(String [] arga){


        try{
            ServerSocket ss = new ServerSocket(1001);

            File file = new File("../JavaTest2/Exam1/temp/ampleChapter1.pdf");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            StringBuffer total = new StringBuffer();

            String line;
            while ((line = br.readLine())!=null) {
                total.append(String.valueOf(line));
                total.append("\n");
            }

            br.close();

            Socket s = ss.accept();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            bw.write(total.toString());
            bw.flush();
            bw.close();


        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
