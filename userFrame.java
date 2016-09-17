package frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import arithmetic.Deciphering;
import arithmetic.Encrypt;
/**
 * 内界面
 * @author 15055
 *
 */
public class userFrame extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String message="";
	private JPanel panel,transfer;
	private GroupLayout contentPane;
	private JScrollPane left,right;
	private JButton convert;
	private ImageIcon change;
	private JTextPane right1,left1;
	public userFrame()
	{
		try 
		{
			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		} 
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) 
		{
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
		
		//左边的文本框
		left = new JScrollPane();   
		//右边的文本框
		right = new JScrollPane();  
		
		//按钮图片
		change  = new ImageIcon("picture/1.gif");
		//转化按钮
		convert = new JButton(change); 
		convert.addActionListener(this);
		
		right1 = new JTextPane();
		right.setViewportView(right1);
		left1 = new JTextPane();
		//获取文本框中的信息，存到字符串message中
		message = left1.getText();
		left.setViewportView(left1);
		panel.add(transfer());
	}
	public JPanel transfer()
	{
		transfer = new JPanel();
		contentPane = new GroupLayout(transfer);
		contentPane.setHorizontalGroup   //设置沿水平轴确定组件位置和大小的 Group
		(
				contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(contentPane.createSequentialGroup()
						.addGap(10)
						.addComponent(left, GroupLayout.PREFERRED_SIZE,400, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED,37, Short.MAX_VALUE)
						.addComponent(convert)
						.addPreferredGap(ComponentPlacement.RELATED,50, Short.MAX_VALUE)
						.addComponent(right, GroupLayout.PREFERRED_SIZE,450, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
		contentPane.setVerticalGroup    //设置沿垂直轴确定组件位置和大小的 Group
		(
				contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
					.addContainerGap(307, Short.MAX_VALUE)
					.addComponent(convert)
					.addGap(290))
				.addGroup(Alignment.TRAILING, contentPane.createSequentialGroup()
					.addGroup(contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, contentPane.createSequentialGroup()
							.addGap(107)
							.addComponent(right, GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
						.addGroup(contentPane.createSequentialGroup()
							.addGap(116)
							.addComponent(left, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)))
					.addGap(129))
			);
		transfer.setLayout(contentPane);
		return transfer;
	}
	/**
	 * 主函数
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new userFrame();
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(mainFrame.s.equals("1"))
		{
			if(e.getSource()==convert)
			{
				encrypt();
			}
		}
		else
		{
			message = left1.getText();
			if(e.getSource()==convert)
			{
				deciphering();
			}
		}
	}
	/**
	 * 加密
	 */
	public void encrypt()
	{
		message = left1.getText();
		if(message.length()!=0)
		{
			Encrypt.run1();
			right1.setText(Encrypt.run22);
			Encrypt.run22="";
		}
		else
		{
			right1.setText("");
		}
	}
	/**
	 * 解密
	 */
	public void deciphering()
	{
		if(message.length()!=0)
		{
			Deciphering.t1();
			right1.setText(Deciphering.e);
			Deciphering.e="";
		}
		else
		{
			right1.setText("");
		}
	}
}
