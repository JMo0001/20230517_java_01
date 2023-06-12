package kh.lclass.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public void testTcpClient(String ip, int port) {

		Socket socket = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedReader br = null;
		PrintWriter pr = null;

		// console에 입력한 문자 읽어들이기 위한 객체
//		방법1. Scanner sc = new Scanner(System.in);

		/* 방법2. */BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		try {
			// 1. 서버의 ip주소와 서버가 정한 포트번호를 매개변수로 하여 클라이언트용 소켓 객체 생성
			socket = new Socket(ip, port);
			System.out.println("서버에 연결중...");
			System.out.println("서버에 포트 "+socket.getLocalPort());
			System.out.println("나의 port"+socket.getPort());
			
			// 5. 연결된 클라이언트와 입출력 스트림 생성
			in = socket.getInputStream();
			out = socket.getOutputStream();
			// 6. 보조 스트림을 통해 성능 개선
			br = new BufferedReader(new InputStreamReader(in));
			pr = new PrintWriter(new OutputStreamWriter(out));

			pr.write("반갑습니다.");
			pr.flush();

			String sendMsg = null;
			while (true) {

				System.out.print("메시지>>");
				sendMsg = stdIn.readLine(); // console에 입력한 문자 읽어들이기
				System.out.println(sendMsg);

				pr.println(sendMsg);
				pr.flush();

				String receivedMsg = br.readLine();
				System.out.println("서버로부터 받은 메시지 : " + receivedMsg);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stdIn != null) stdIn.close();
				if (pr != null)	pr.close();
				if (br != null)	br.close();
				if (in != null)	in.close();
				if (out != null) out.close();
				if (socket != null)	socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
