package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class Browsersample {

	public static void main(String[] argv) {

		MyFrame m = new MyFrame();

		m.setTitle("samplebrowser");
		m.setSize(500, 300);
		m.setLocation(200, 300);
		m.setVisible(true);

	}
}

class MyFrame extends JFrame implements ActionListener, HyperlinkListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1, panel2, panel3;
	JButton button1, button2, button3;
	JLabel label1;
	JEditorPane pane;
	JScrollPane scrollpane;
	JTextField field1;

	MyFrame() {
		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		this.add(panel1, BorderLayout.NORTH);
		panel1.setLayout(new FlowLayout());
		button1 = new JButton("后退", new ImageIcon("back.png"));
		button2 = new JButton("前进", new ImageIcon("forward.png"));
		field1 = new JTextField(20);
		button3 = new JButton("转到", new ImageIcon("go.png"));

		panel1.add(button1);
		panel1.add(button2);
		panel1.add(field1);
		panel1.add(button3);
		JPanel panel2 = new JPanel();
		this.add(panel2, BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout());
		pane = new JEditorPane();
		pane.setEditable(false);
		scrollpane = new JScrollPane(pane);
		panel2.add(scrollpane);
		JPanel panel3 = new JPanel();
		this.add(panel3, BorderLayout.SOUTH);
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
		label1 = new JLabel("Welcome");
		panel3.add(label1);

		button3.addActionListener(this);
		pane.addHyperlinkListener(this);

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == button3)

		{
			String s = field1.getText();

			if (!s.startsWith("http://"))
				s = "http://" + s;

			try {

				URL u = new URL(s);
				pane.setPage(u);

				/*
				 * if(s.startsWith("http//:www.")==true)
				 * 
				 * pane.setPage("http//:www."+u);
				 * 
				 * else if(s.startsWith("ftp//:")==true)
				 * 
				 * pane.setPage("ftp//:"+u);
				 * 
				 * else pane.setPage(u);
				 */

			} catch (Exception f) {
			}
		}

	}

	public void hyperlinkUpdate(HyperlinkEvent m) {
		try {
			URL r = m.getURL();
			if (m.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
				pane.setPage(r.toString());
			if (m.getEventType() == HyperlinkEvent.EventType.ENTERED)
				label1.setText(r.toString());
			if (m.getEventType() == HyperlinkEvent.EventType.EXITED)
				label1.setText("Welcome");
		} catch (Exception e2) {
		}

	}

}
