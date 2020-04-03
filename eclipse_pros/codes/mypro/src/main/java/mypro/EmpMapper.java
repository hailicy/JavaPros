package mypro;
	
	import java.io.IOException;
	
	import org.apache.hadoop.io.IntWritable;
	import org.apache.hadoop.io.LongWritable;
	import org.apache.hadoop.io.Text;
	import org.apache.hadoop.mapreduce.Mapper;
	
	public class EmpMapper extends Mapper<LongWritable, Text, IntWritable, Emp> {
	
		@Override
		protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, IntWritable, Emp>.Context context)
				throws IOException, InterruptedException {
			// TODO Auto-generated method stub
			// super.map(key, value, context);
			String data = value.toString();
			String[] words = data.split(",");
			Emp e = new Emp();
			e.setEmpno(Integer.parseInt(words[0]));
			e.setEname(words[1]);
			e.setJob(words[2]);
			try {
				e.setMgr(Integer.parseInt(words[3]));
			} catch (Exception ex) {
				e.setMgr(-1);
			}
			e.setHiredate(words[4]);
			e.setSal(Integer.parseInt(words[5]));
			try {
				e.setComm(Integer.parseInt(words[6]));
			} catch (Exception ex) {
				e.setComm(0);
			}
			e.setDeptno(Integer.parseInt(words[7]));
			context.write(new IntWritable(e.getDeptno()), e);
		}
	
	}