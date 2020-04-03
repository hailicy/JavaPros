package mypro;
import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.fs.BlockLocation;
//import org.apache.hadoop.fs.FSDataOutputStream;
//import org.apache.hadoop.fs.FileStatus;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.LocatedFileStatus;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;
import org.apache.hadoop.io.IOUtils;
//import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;



import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsDemo {
    //��ʼ������
    FileSystem fs = null;
    //����fs����
    @Before
    public void init() throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new  Configuration();
        //�����ļ�ϵͳΪhdfs
        //��ȡ�ļ�ϵͳ�Ŀͻ���ʵ������
        //ע�⣺���г�����Ҫִ���û���Ϊhadoop,��������ûдȨ�޵����
        //fs = FileSystem.get(new URI("hdfs://192.168.226.110:8020"),configuration,"root");
        //fs = FileSystem.get(configuration);
        URI uri=new URI("hdfs://192.168.204.129:8020");
        fs = FileSystem.get(uri,configuration,"hadoop");
        
    }
    
    //�ϴ��ļ�
    @Test
    public void testUpload() throws IOException {
        //fs.copyFromLocalFile(new Path("D://apps/eclipse/codes/uptest.txt"),new Path("/input/uptest.txt"));
        Path x = new Path("D://apps/eclipse/codes/uptest2019.11.8.txt");
        Path y = new Path("/input/uptest2019.11.8.txt");
        fs.copyFromLocalFile(x, y);
    	//InputStream is = new FileInputStream("D://apps/eclipse/codes/uptest.txt");
    	//OutputStream os = fs.create(new Path("/input/uptest.txt"));
    	//IOUtils.copyBytes(is, os, 1024);
    	//is.close();
    	//os.close();
    	fs.close();
    	System.out.println("�ϴ��ļ��ɹ���");
    }
   
    //�����ļ�
    @Test
    public void testDownLoad() throws IOException {
        //fs.copyToLocalFile(new Path("/input/data.txt"),new Path("D://apps/eclipse/codes/download333.txt"));
        InputStream is = fs.open(new Path("/input/data.txt"));
        OutputStream os = new FileOutputStream("D://apps/eclipse/codes/download2019.11.8.txt");
    	IOUtils.copyBytes(is, os, 1024);
    	is.close();
    	os.close();
    	fs.close();
        System.out.println("���سɹ���");
    }

    //�����ļ���
    @Test
    //�����µ��ļ���
    public void testMakeDir() throws Exception {
        boolean mkdirs = fs.mkdirs(new Path("/input/demo2019.11.8"));
        System.out.println(mkdirs+"\n�������ļ��гɹ���");
        
    }
    
    /**
    @Test
    //�����µ��ļ�
    public void txtMake() throws Exception {
        //boolean mkdirs = fs.mkdirs(new Path("/demo1"));
        //System.out.println(mkdirs+"\n�����ļ��гɹ���");
    	Path dfs = new Path("/input/wordtest.txt");
    	FSDataOutputStream os = fs.create(dfs,true);
    	dfs.writeBytes("Hello,hdfs!");
    	os.close();
    	fs.close();
    
    }*/
    
    
    @Test
    //ɾ���ļ�
    public void testDelete() throws Exception{
        //�ڶ�������Ϊtrue�ǵݹ�ɾ��
        boolean delete = fs.delete(new Path("/input/uptest.txt"), true);
        //Path path=new Path("/input/wordtest.txt");
        //fs.delete(path);
        fs.close();
        //System.out.println("ɾ���ļ��ɹ���");
    	System.out.println(delete+"\nɾ���ļ��ɹ���");
    }
    
    //�����޸��ļ��е�����
    @Test
    public void testRenameDir() throws IOException {
        boolean change = fs.rename(new Path("/070"),new Path("/070changed"));
        System.out.println(change);
    }
    
    
    //���Բ鿴Ŀ¼��Ϣ����
    @Test
    public void testListFiles() throws IOException {
    	//�ڶ�������Ϊtrue��ʾ�ݹ����
           RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"),true);

           while (listFiles.hasNext()){
//��ӡ�����ļ���Ϣ������������ִ�� hdfs dfs -lsr / Ч��һ��
               LocatedFileStatus status = listFiles.next();
               System.out.println(status.getPath().getName());
               System.out.println(status.getBlockSize());
               System.out.println(status.getPermission());
               System.out.println(status.getLen());
//��ӡ�ļ���ÿ������λ�ã�ÿ128Mһ������
               BlockLocation[] blockLocations = status.getBlockLocations();
               for(BlockLocation bl:blockLocations){
                   System.out.println("block-length:"+bl.getLength()+"--"+
                           "block-offset:"+bl.getOffset());
                   String[] hosts = bl.getHosts();

                   for(String host:hosts){
                       System.out.println(host);
                   }
               }
               System.out.println();
           }
       }
    
    //�鿴�ļ��Լ��ļ�����Ϣ
    @Test
    public void testListAll() throws IOException {
        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        String flag = "d-----------------";
        for(FileStatus fileStatus:listStatus){
            if(fileStatus.isFile())
                flag = "f----------------";
            else
                flag = "d----------------";
            System.out.println(flag+fileStatus.getPath().getName());
        }
    }
    
 }