package kh.lclass.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpEchoSender {
	public static void main(String[] args) {
		new UdpEchoSender().senderUdp();
	}

	public void senderUdp() {
		// 포트번호 정함
		int myport = 5001;
		int destport = 6001;
		String destName = "localhost";
		BufferedReader br = null;
		// DatagramSocket 생성
		DatagramSocket dSock = null;
		try {
			dSock = new DatagramSocket(myport);
			// 매개인자 없으면 자동 port 번호 할당.
											//System.in이 기반스트림 역할.
			br = new BufferedReader(new InputStreamReader(System.in));
													
			while (true) {
				// 전달할 메시지
				System.out.println("입력 >>");
				String sendMsg = br.readLine();
				//exit 입력하여 프로그램 끝내기
				if(sendMsg.equals("exit")) {
					break;
				}

				// 메시지 전달
				InetAddress destIp = null;
				try {
//			3. 연결한 클라이언트 ip주소를 가진 InetAddress 객체 생성.
					destIp = InetAddress.getByName(destName);
//			4. 전송할 메시지를 byte[]로 바꿈.
					byte[] byteMst = sendMsg.getBytes();
//			5. 전송할 메시지를 DatagramPacket 객체에 담음.
					DatagramPacket sendData = 
							new DatagramPacket(byteMst, byteMst.length, destIp, destport);
//			6. 소켓 레퍼런스를 사용하여 메시지 전송
					dSock.send(sendData);

				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				//메시지 수신
				byte[] byteMsg = new byte[1000];
				//수신받을 메시지 DatagramPacket 객체에 담음
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
//				
				String receivedStr = new String(receivedData.getData());
				System.out.println("eho메시지 :"+receivedStr);
				
				
				

			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (dSock != null) dSock.close();
			if(br!=null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

	}

}
