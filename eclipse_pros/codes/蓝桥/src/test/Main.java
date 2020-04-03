package test;

import java.util.*;

public class Main {

	public static void main(String[] args){
		//一个完整的输入过程
		String str="";//用于保存输入的文本
		Scanner scan=new Scanner(System.in);//建立一个输入对象scan
		int n= scan.nextInt();
		//从键盘接收数据
//		if(scan.hasNextLine()){
//	    str=scan.nextLine();//可以输入空格，直到遇到回车时结束输入,next()则不能获得带空格的字符串
//		}
		scan.close();
		
//		Integer in=new Integer(str);
//		int n=in.intValue();
		int s=0,m=0;
		for(int i=1;i<=n;i++){
		m+=i;
		s+=m;
		}
		System.out.print(s);
	}
}
