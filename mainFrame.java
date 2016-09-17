package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;

public class mainFrame extends JFrame implements ActionListener
{
	/**
	 * 恩尼格码密码机主界面
	 */
	public static String s;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private GroupLayout contentPane;
	private JButton encrypt,deciphering; //encrypt加密，deciphering解密
	private JLabel author,copyright;
	public mainFrame()
	{
		try 
		{
			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} 
		catch 
		(ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init();
		setTitle("恩尼格码密码机");
		setVisible(true);
		setSize(1010,630);   //设置界面大小
		setResizable(false);//不可改变大小
		setLocationRelativeTo(null);//居中显示
	}
	public void init()
	{
		panel = new JPanel();
		setContentPane(panel);
	    encrypt = new JButton("加密");
	    //设置事件监听
	    encrypt.addActionListener(this); 
		deciphering = new JButton("解密");
		//设置事件监听
		deciphering.addActionListener(this);
		author = new JLabel("Made  in  Engineman");
		copyright = new JLabel("International Business   阿会版权所有   2016-20**   ICP证: 浙A8-20160087");
		contentPane = new GroupLayout(panel);
		contentPane.setHorizontalGroup
		(
				contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(contentPane.createSequentialGroup()
						.addGroup(contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(contentPane.createSequentialGroup()
								.addGap(400)   //encrypt的水平位置，同时影响deciphering的位置
								.addComponent(encrypt)
								.addGap(100)   //两个按钮之间的间距
								.addComponent(deciphering))
							.addGroup(contentPane.createSequentialGroup()
								.addGap(445)    //author的水平位置
								.addComponent(author, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addGroup(contentPane.createSequentialGroup()
								.addGap(320)   //copyright的水平位置
								.addComponent(copyright)))
						.addContainerGap(414, Short.MAX_VALUE))
			);
		contentPane.setVerticalGroup
		(
				contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(contentPane.createSequentialGroup()
						.addGap(256)   //按钮的垂直位置
						.addGroup(contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(encrypt)
							.addComponent(deciphering))
						.addGap(266)   //作者的垂直位置
						.addComponent(author)
						.addGap(5)    //版权的垂直位置
						.addComponent(copyright)
						.addContainerGap(31, Short.MAX_VALUE))
			);
		panel.setLayout(contentPane);
	}
	public static void main(String[] args) 
	{
		new mainFrame();
	}
	/**
	 * 两个按钮的事件监听
	 */
	public void actionPerformed(ActionEvent e) 
	{
		/**
		 * 加密按钮
		 */
		if (e.getSource() == encrypt)
		{
			s="1";
			new userFrame();
			this.dispose();
		}	
		/**
		 * 解密按钮
		 */
		else
		{
			s="2";
			new userFrame();
			this.dispose();
		}
	}
}
