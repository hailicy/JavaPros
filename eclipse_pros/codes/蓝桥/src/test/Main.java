package test;

import java.util.*;

public class Main {

	public static void main(String[] args){
		//һ���������������
		String str="";//���ڱ���������ı�
		Scanner scan=new Scanner(System.in);//����һ���������scan
		int n= scan.nextInt();
		//�Ӽ��̽�������
//		if(scan.hasNextLine()){
//	    str=scan.nextLine();//��������ո�ֱ�������س�ʱ��������,next()���ܻ�ô��ո���ַ���
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
