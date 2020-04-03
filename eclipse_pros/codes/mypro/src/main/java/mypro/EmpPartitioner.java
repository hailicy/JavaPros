package mypro;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class EmpPartitioner extends Partitioner<IntWritable,Emp>{

	@Override
	public int getPartition(IntWritable k3, Emp e, int num) {
		// TODO Auto-generated method stub
		//return 0;
		if(e.getSal()<1500) {
			return 0%num;
		}else if(e.getSal()>=1500 && e.getSal()<3000) {
			return 1%num;
		}else {
			return 2%num;
		}
	}
}