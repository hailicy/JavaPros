package mypro;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class EmpReducer extends Reducer<IntWritable,Emp,NullWritable,Emp>{

	@Override
	protected void reduce(IntWritable k3, Iterable<Emp> v3,
			Reducer<IntWritable, Emp, NullWritable, Emp>.Context context) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
		for(Emp e:v3) {
			context.write(NullWritable.get(), e);
		}
	}
}