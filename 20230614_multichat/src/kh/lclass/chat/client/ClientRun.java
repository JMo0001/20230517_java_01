package kh.lclass.chat.client;

import javax.swing.JOptionPane;

public class ClientRun {
	public static void main(String[] args) {
		// 사용자 nickname을 GUI를 통해서 입력받음.
		String nickname = JOptionPane.showInputDialog("닉네임을 입력해 주세요.");
		new ClientGUI(nickname);
	}

}
