import java.net.*;
import java.io.*;
import java.time.LocalTime;
import java.util.*;
import packets.packet;												//importing packages

public class client{

    public static void main(String args[]) {
	    System.out.println("Establishing Connection");
	    packet[] str={new packet("Hello Server"), new packet("This is a warmup exercise"),new packet("exit")}; //Declaring packets array

    try
    {
	InetAddress add = InetAddress.getLocalHost();                                                              //Getting the local host ip
        Socket s = new Socket(add.getHostAddress(),9999);                                                          //Opening socket on port 9999 
	
	ObjectOutputStream msg = new ObjectOutputStream(s.getOutputStream());                                      //Get output stream from socket
	int i = 0;
	while(true){
	System.out.println("Sending Message : "+str[i].message()+"         " + LocalTime.now() );         //Printing the message to be sent to server
	msg.writeObject(str[i]);                                                                          //Sending packets
	if((str[i].message()).equals("exit")==true) {                                                     //Terminating connection
        System.out.println("Connection is lost.....");
        System.exit(1);
        }
	Thread.sleep(10000);							                          //10 sec sleep
	i++;
	msg.flush();											  //Flushing the Output Stream
	}
    }
    catch(InterruptedException e){
	    System.out.println(e);
    }
    catch(UnknownHostException e) {
		System.out.println("Something went wrong" +e);
	}
    catch(IOException e) {
	    System.out.println("No Data" +e);
    }
    }
}
