package kh.lclass.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoReceiver {
	public static void main(String[] args) {
		new UdpEchoReceiver().receiverUdp();
	}
	
	public void receiverUdp() {
		//포트번호 정함
		int myPort = 6001;
//		int destPort = 5001;
//		String destName = "loacalhost";
		DatagramSocket dSock = null;
		
		try {//DatagramSocket 객체 생성
			dSock = new DatagramSocket(myPort);
			
			//메시지 수신
			while(true) {
				byte[] byteMsg = new byte[1000];
				DatagramPacket receivedData 
				= new DatagramPacket(byteMsg, byteMsg.length);
				dSock.receive(receivedData);
				
				//전달받은 메시지 정보들
//				System.out.println("===전달받은 정보들===");
//				System.out.println(byteMsg.length);//바이트 배열의 크기
//				System.out.println(receivedData.getData().length);
//				System.out.println(receivedData.getLength());//받은 메시지 크기
//				System.out.println(receivedData.getAddress());//발신자 Ip
//				System.out.println(receivedData.getPort());//발신자 Port
				
				String receivedStr = new String(receivedData.getData());
				System.out.println("수신메시지 :"+receivedStr);
				
				
				//echo 메시지 송신
				DatagramPacket sendData 
				= new DatagramPacket(receivedData.getData(), receivedData.getLength(), receivedData.getAddress(), receivedData.getPort());
				dSock.send(sendData);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
