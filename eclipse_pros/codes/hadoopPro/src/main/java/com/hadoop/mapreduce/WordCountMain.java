package com.hadoop.mapreduce;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordCountMain {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException  {
		// TODO Auto-generated method stub

		Job job = Job.getInstance(new Configuration());
		job.setJarByClass(WordCountMain.class); 
		
		job.setMapperClass(WordCountMapper.class);
		job.setMapOutputKeyClass(Text.class);    
		job.setMapOutputValueClass(IntWritable.class); 
	    
		job.setReducerClass(WordCountReducer.class);
		job.setOutputKeyClass(Text.class); 
		job.setOutputValueClass(IntWritable.class); 
     
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true);
	}

}