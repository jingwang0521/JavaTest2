package com.hand;

public class Exam2
{
    public static void main( String[] args )
    {
    	NewServer newServer=new NewServer();
    	NewClient newClient=new NewClient();
		newServer.start();
		newClient.start();

    }
}
