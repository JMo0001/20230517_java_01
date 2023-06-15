package kh.lclass.chat.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = -6309558503354317301L;
	
	private JTextArea jta = new JTextArea(40, 25);	//채팅 창
	private JTextField jtf = new JTextField(80);	//글 입력 부분
	
	private String nickName;	//클라이언트 닉네임 
	private ClientBackground cb = new ClientBackground();// 채팅 socket기능을 담당할 객체 생성
	
	
	public ClientGUI(String nickname) {
		this.nickName = nickname;
		
		
		setBounds(200, 100, 400, 600);
		setTitle(nickname+"님 창");
		
		jta.setEditable(false);
		jta.setFont(new Font("맑은고딕", Font.PLAIN, 18));
		jta.setBackground(new Color(230, 255, 230));
		
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		cb.setNickname(nickname);
		cb.setGui(this);
		cb.connection();
		
	}
	
	// 새 메시지를 받았을때 메소드 호출됨.
	public void appendMsg(String msg) {
		//jta(채팅창)에 msg를 추가함.
		jta.append(msg);
		jta.append("\n");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = jtf.getText();
		System.out.println(msg);
		jtf.setText("");
		cb.sendMessage(msg);
	}
	

}
