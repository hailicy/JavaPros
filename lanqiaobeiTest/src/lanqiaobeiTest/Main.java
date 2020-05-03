package lanqiaobeiTest;

import java.util.*;

//第一行输入数组长度
//第二行输入数组，用空格隔开
public class Main {

	public static void main(String[] args){
		Scanner scan=new Scanner(System.in);//建立一个输入对象scan
		String n = scan.nextLine();
		Integer nn = new Integer(n);
		String[] arr = new String[nn];
		String string = scan.nextLine();
		scan.close();
		arr=string.split(" ");
		int[] ans = new int[nn];
		Integer tempInteger;
		for(int i=0;i<nn;i++) {
			tempInteger = new Integer(ans[i]);
			ans[i]=Integer.parseInt(arr[i]);
		}
		sort(ans);
		for(int i=0;i<ans.length;i++) {
			System.out.print(ans[i]);
			System.out.print(" ");
		}
	}
	
	
	
	static void sort(int[] a) {
		int temp;
		for(int i=0;i<a.length-1;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
				}
			}

		}
		
		
		
		
	}
}