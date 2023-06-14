package kh.lclass.chat.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ServerBackground {
	private ServerSocket serverSocket;	//서버소켓
	private ServerGUI gui;	//null	//new 하면 안됨
	
	//Client 여러명을 관리 >> key : nickname, value : outputStream
	private Map<String, BufferedWriter> mapClients = new HashMap<String, BufferedWriter>();
	//map.put("ej", socket);
	//mpa.put("hs"m scoket);
	private Socket socket;
	private int count;	//현재 접속자 수
	
	// 서버 생성 및 설정
	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			//방문자 접속을 계속 받아들임 >> while(true)인 이유 >> 무한반복.
			//GUI 프로그램경우 창 닫힐때까지 계속 반복됨. break 없음.
			while(true) {	
				//접속자 기다리는 중
				socket = serverSocket.accept();	// 클라이언트 받음.
				new Client(socket).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 클라이언트 접속하면 그 정보를 나타내 주는 메소드
	public void addClient(String nickname) {
		gui.appendMsg(nickname+"님이 접속했습니다.");
	}
	
	
		
	// private ServerGUI gui;
	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}
	public void sendMessage(String msg) {
		// client들 모두에게 msg 전달
		Set<String> keys = mapClients.keySet();
		for(String key : keys) {	//keys를 String key값으로 받겠다.
			BufferedWriter wr = mapClients.get(key);//mapClients 자료형은 bufferdWriter
			try {
				wr.write(msg+"\n");
				wr.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
		
		////////////////////////////////////////////////////////
		/*Inner class.(위쪽 클래스의 필드를 좀 쓰고싶다.)*/
class Client extends Thread{
//	private Socket socket; 위쪽에 있음
	private BufferedReader br;
	private BufferedWriter bw;
	private String nickname;
	public Client(Socket socket) {
		//초기값 설정
		//client의 입/출력 통로 생성
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			// client nickname이 바로 이어서 들어옴.
			// 접속되면 바로 nickname이 전달될 것이므로 읽음.
			String nickname = br.readLine();
			//server 화면에 표현
			addClient(nickname);
			// client outputStream관리 map에 추가
			mapClients.put(nickname, bw);
			// client map 모두에게 접속 정보 전달
			sendMessage(nickname+"님이 접속했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
			
	@Override
	public void run() {
		//클라이언트마다 각각에서 전달되어오는 메시지를 확인하고 화면에 출력
		//client에서 수신받은 msg
		while(br != null) {
			try {
				String msg = br.readLine();	//client의 입력 통로가 끊기지 않으면 계속 반복확인.
				gui.appendMsg(msg);
				// client map 모두에게 접속 정보 전달
				sendMessage(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
//			gui.appendMsg(msg); 오류나서 캐치에 잡히면 화면에 낼 필요 없다. >> 위로 옮긴다.
					
			}
		}
	}
}	// 


