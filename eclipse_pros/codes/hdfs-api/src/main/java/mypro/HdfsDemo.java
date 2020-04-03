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
    //初始化环境
    FileSystem fs = null;
    //创建fs对象
    @Before
    public void init() throws IOException, URISyntaxException, InterruptedException {
        Configuration configuration = new  Configuration();
        //设置文件系统为hdfs
        //获取文件系统的客户端实例对象
        //注意：运行程序是要执行用户名为hadoop,否则会出现没写权限的情况
        //fs = FileSystem.get(new URI("hdfs://192.168.226.110:8020"),configuration,"root");
        //fs = FileSystem.get(configuration);
        URI uri=new URI("hdfs://192.168.204.129:8020");
        fs = FileSystem.get(uri,configuration,"hadoop");
        
    }
    
    //上传文件
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
    	System.out.println("上传文件成功！");
    }
   
    //下载文件
    @Test
    public void testDownLoad() throws IOException {
        //fs.copyToLocalFile(new Path("/input/data.txt"),new Path("D://apps/eclipse/codes/download333.txt"));
        InputStream is = fs.open(new Path("/input/data.txt"));
        OutputStream os = new FileOutputStream("D://apps/eclipse/codes/download2019.11.8.txt");
    	IOUtils.copyBytes(is, os, 1024);
    	is.close();
    	os.close();
    	fs.close();
        System.out.println("下载成功！");
    }

    //创建文件夹
    @Test
    //创建新的文件夹
    public void testMakeDir() throws Exception {
        boolean mkdirs = fs.mkdirs(new Path("/input/demo2019.11.8"));
        System.out.println(mkdirs+"\n创建新文件夹成功！");
        
    }
    
    /**
    @Test
    //创建新的文件
    public void txtMake() throws Exception {
        //boolean mkdirs = fs.mkdirs(new Path("/demo1"));
        //System.out.println(mkdirs+"\n创建文件夹成功！");
    	Path dfs = new Path("/input/wordtest.txt");
    	FSDataOutputStream os = fs.create(dfs,true);
    	dfs.writeBytes("Hello,hdfs!");
    	os.close();
    	fs.close();
    
    }*/
    
    
    @Test
    //删除文件
    public void testDelete() throws Exception{
        //第二个参数为true是递归删除
        boolean delete = fs.delete(new Path("/input/uptest.txt"), true);
        //Path path=new Path("/input/wordtest.txt");
        //fs.delete(path);
        fs.close();
        //System.out.println("删除文件成功！");
    	System.out.println(delete+"\n删除文件成功！");
    }
    
    //测试修改文件夹的名称
    @Test
    public void testRenameDir() throws IOException {
        boolean change = fs.rename(new Path("/070"),new Path("/070changed"));
        System.out.println(change);
    }
    
    
    //测试查看目录信息功能
    @Test
    public void testListFiles() throws IOException {
    	//第二个参数为true表示递归调用
           RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"),true);

           while (listFiles.hasNext()){
//打印各种文件信息，和命令行中执行 hdfs dfs -lsr / 效果一样
               LocatedFileStatus status = listFiles.next();
               System.out.println(status.getPath().getName());
               System.out.println(status.getBlockSize());
               System.out.println(status.getPermission());
               System.out.println(status.getLen());
//打印文件的每个分组位置，每128M一个分组
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
    
    //查看文件以及文件夹信息
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