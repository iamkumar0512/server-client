import java.net.*;
import java.time.LocalTime;
import java.io.*;
import java.util.*;
import packets.packet;											//importing packages


public class server {
    public static void main(String args[])
    {
    try
    {
	ServerSocket ss = new ServerSocket(9999);							//Socket is listening to port 9999
	System.out.println("Waiting for the client request");
		
       	Socket s = ss.accept();	
        
       	System.out.println("clientConnected");
	ObjectInputStream br = new ObjectInputStream(s.getInputStream());				//Get input stream from socket
	while(true) {	
	packet str =( packet) br.readObject();
	packet check = new packet(str.message());							//New packet generated to authenticate

	if(check.checksum()==str.checksum())                                                  	        //authentication check
	System.out.println("Client : "+str.message()+"        " +LocalTime.now());			//printing the object recieved
	else
	System.out.println("Authentication Failed");

	if( (str.message()).equals("exit")==true) {							//Terminating Connection
		System.out.println("Connection is lost.....");
		break;
	}

    }
	}
	catch(IOException e) {
	       System.out.println("No Data" +e);
	}
	catch(ClassNotFoundException e) {
		System.out.println("No Class" +e);
	}

    }
}
