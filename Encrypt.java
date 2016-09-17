package arithmetic;

import frame.userFrame;

public class Encrypt 
{
	public static int[] password;
	public static String run11,run12="",run13,run14="",run21,run22="",run31,run32="";
	public static int password2;
    public static int char2ASCII(char c) 
    {  
        return (int) c;  
    }  
    /**
     * 第一次加工：字符串转unicode码
     * 例如:李明会--->26446 26126 20250
     * @param s
     * @return
     */
    public static int[] string2ASCII(String s) 
    { 
        if (s == null || "".equals(s)) 
        {  
            return null;  
        }  
        char[] chars = s.toCharArray();  
        int[] asciiArray = new int[chars.length];  
  
        for (int i = 0; i < chars.length; i++) 
        {  
            asciiArray[i] = char2ASCII(chars[i]);  
        }  
        return asciiArray;  
    }  
    /**
     *  第二次加工：将unicode码按长度标识好
     *  0<length<100，标识为A
     *  99<length<1000，标识为B
     *  999<length<10000，标识为C
     *  其他长度为D
     *  
     *  例如：李明会--->26446D26126D20250D
     * @param intArray
     * @return
     */
    public static String showIntArray(int[] intArray) 
    {  
        for (int i = 0; i < intArray.length; i++) 
        {  
        	if(intArray[i]>0 && intArray[i]<100)
        	{
        		run11 =intArray[i]+"A";
        	}
        	else if(intArray[i]>99 && intArray[i]<1000)
        	{
        		run11 =intArray[i]+"B";
        	}
        	else if(intArray[i]>999 && intArray[i]<10000)
        	{
        		run11 =intArray[i]+"C";
        	}
        	else
        	{
        		run11 =intArray[i]+"D";
        	}
        	run12 += run11;
        }  
        return run12;
    }  
    /**
     * 第三次加工：将标识好的unicode码挨个转换
     * 例如：26446D-->505452525468
     */
    public static void run1()
    {
		int []a =Encrypt.string2ASCII(userFrame.message);
		 run12 =showIntArray(a);
		 String s=run12;
		//把字符串转换为字符数组
		 char[]chars=s.toCharArray(); 
		 for(int i=0;i<chars.length;i++)
		 {
			 password2 =chars[i];
			 run13 = String.valueOf(password2);
			 run14 += run13;
		 }
//		 System.out.println(run14);
		 run2();
    }
    /**
     * 第四次加工：将字符串按2个一组，将字符串转换成字符串数组
     * 				字符串数组又转换成整形（int）数组，且单个数值+2，例 51+2=53；
     * 				将整形(int)数组转换成二进制输出
     */
    public static String run2()
    {
    	int m = 0,n =2;
		String []a = new String[run14.length()];
		int [] c = new int[a.length];
		for(int i =0;m<run14.length();i++)
		{
			a[i] =run14.substring(m,n);
			m += 2;
			n += 2;
			c[i] = Integer.parseInt(a[i])+2;
			if(String.valueOf(Integer.toBinaryString(c[i])).length()>6)
			{
				run21 =String.valueOf(Integer.toBinaryString(c[i]));
			}
			else
			{
				run21 ="0"+String.valueOf(Integer.toBinaryString(c[i]));
			}
            run22 += run21;
		}
//		run3();
		return run22;
    }
    /**
     * 第五次加工：将二进制转换成8进制，转换的数量是以4位一组
     * 如果遇到位数不足4位的，以0补足
     */
    public static String run3()
    {
    	int m = 0,n =4;
		String []a = new String[run22.length()];
		int [] c = new int[a.length];
		for(int i =0;n<run22.length();i++)
		{
			a[i] =run22.substring(m,n);
			m += 4;
			n += 4;
			if(a[i].length()>3)
			{
				run31 =String.valueOf(Integer.toOctalString(Integer.parseInt(a[i], 2)))+" ";
			}
			else if(a[i].length()==3)
			{
				run31 =String.valueOf(Integer.toOctalString(Integer.parseInt("0"+a[i], 2)))+" ";
			}
			else if(a[i].length()==2)
			{
				run31 =String.valueOf(Integer.toOctalString(Integer.parseInt("00"+a[i], 2)))+" ";
			}
			else if(a[i].length()==1)
			{
				run31 =String.valueOf(Integer.toOctalString(Integer.parseInt("000"+a[i], 2)))+" ";
			}
            run32 += run31;
		}
		return run32;
    }
//	public static void main(String[] args) 
//	{
//		String s = "///啊啊啊啊啊啊啊";  
//		showIntArray(string2ASCII(s), "");
//		System.out.println(b);
//		int c = Integer.parseInt(b);
//		System.out.println(Integer.toOctalString(c));
//	}
}
