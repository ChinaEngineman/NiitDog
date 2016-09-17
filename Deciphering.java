package arithmetic;
/**
 * 解密算法
 * @author 15055
 *
 */
import frame.userFrame;
public class Deciphering 
{
	public static String[]chars;
	public static String s;
	public static String d,e="",t12 ="",t22 ="";
	/**
	 * 第一重转换：将二进制转换成unicode码
	 * 转换规则：将二进制以6位为一组，转换成2位的10进制
	 */
	public static void t1()
	{
		int sta=0,end=7;
		String s =userFrame.message;
		String [] a=new String[s.length()];
		int [] b = new int[a.length];
		String t11;
		for(int i =0;end<s.length();i++)
		{
			a[i] =s.substring(sta,end);
			sta += 7;
			end += 7;
			b[i]=Integer.valueOf(a[i],2)-2;
			t11 =String.valueOf(b[i]);
			t12 += t11;
		}
		t2();
	}
	/**
	 * 第二重加工：将得到的字符串，以二位为一组，进行反转换
	 * 即,ACSII码转字符串
	 */
	public static void t2()
	{
		int sta=0,end=2;
		String s =t12;
		String [] a=new String[s.length()];
		char [] b = new char[a.length];
		String t21;
		for(int i =0;sta<s.length();i++)
		{
			a[i] =s.substring(sta,end);
			sta += 2;
			end += 2;
			b[i]=(char)Integer.parseInt(a[i]);
			t21 =String.valueOf(b[i]);
			t22 += t21;
		}
		t3();
	}
	/**
	 * 第三重转换：将得到的字符串，以A，B，C，D为分界线
	 * 切割成块状ASCII码，分别转成汉子及其他可读字符
	 * @return
	 */
	 public static String t3()
	 {
		 s=t22;//ASCII码
		 chars=s.split("A|B|C|D");
        for(int i=0;i<chars.length;i++)
        {
            char c =(char)Integer.parseInt(chars[i]);
            d=String.valueOf(c);
            e += d;
        }
        return e;
	}
	public static void main(String[] args) 
	{
		t1();
//		System.out.println(e);
	}
}
