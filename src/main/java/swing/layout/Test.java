package swing.layout;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Test {
	static final int WIDTH = 300;
	static final int HEIGHT = 200;

	public static void main(String[] args) {
		JFrame jf = new JFrame("测试程序1");
		jf.setSize(WIDTH, HEIGHT);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		JButton b1 = new JButton("生活");
		JButton b2 = new JButton("工作");
		BorderLayout lay = new BorderLayout();// 创建一个布局管理器对象，将中间容器设置为此布局管理
		jf.setLayout(lay);
		contentPane.add(b1, "North");
		JPanel P1 = new JPanel();
		JTextField jta = new JTextField();
		b2.setBackground(Color.RED);
		P1.add(jta);
		contentPane.add(P1, "South");
		// contentPane.add(jta, "South");
		jf.setVisible(true);
	}
}
