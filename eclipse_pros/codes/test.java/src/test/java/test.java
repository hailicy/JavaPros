package test.java;
/**
 * Ŀ�ģ�ʵ�ֺ�ŵ���������
 * ���ߣ�Dmego  ʱ�䣺2016-10-15
 */
import java.util.Scanner;

public class test {
    static int m =0;//����ƶ�����
    //ʵ���ƶ��ĺ���
    public static void move(int disks,char N,char M)
    {
        System.out.println("��" + (++m) +" ���ƶ� : " +" �� "+ disks+" ��Բ�̴� " + N +" ->�Ƶ�->  " + M);
    }
    //�ݹ�ʵ�ֺ�ŵ���ĺ���
    public static void hanoi(int n,char A,char B,char C)
    {
        if(n == 1)//Բ��ֻ��һ��ʱ��ֻ�轫���A���Ƶ�C��
            move(1, A, C);//����b��Ϊ1��Բ�̴�A�Ƶ�C
        else
        {//����
            hanoi(n - 1, A, C, B);//�ݹ飬��A���ϱ��1~n-1��Բ���Ƶ�B�ϣ���CΪ������
            move(n, A, C);//��A���ϱ��Ϊn��Բ���Ƶ�C��
            hanoi(n - 1, B, A, C);//�ݹ飬��B���ϱ��1~n-1��Բ���Ƶ�C�ϣ���AΪ������
        }
    }
    public static void main(String[] args) {
        Scanner imput = new Scanner(System.in);
        char A = 'A';
        char B = 'B';
        char C = 'C';
        System.out.println("******************************************************************************************");
        System.out.println("���Ǻ�ŵ�����⣨��A���ϱ�Ŵ�С�ŵ���ŵ�Բ�̴�A��ͨ��B�������ƶ���C����ȥ");
        System.out.println("******************************************************************************************");
        System.out.print("������Բ�̵ĸ�����");
        int disks = imput.nextInt();
        hanoi(disks, A, B, C);
        System.out.println(">>�ƶ���" + m + "�Σ���A�ϵ�Բ�̶��ƶ�����C��");
        imput.close();
    }

}