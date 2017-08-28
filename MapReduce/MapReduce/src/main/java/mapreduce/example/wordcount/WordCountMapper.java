package mapreduce.example.wordcount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String w = value.toString();
		String data[] = w.split(" ");
		for (String s : data) {
			context.write(new Text("COUNT"), new IntWritable(1));
		}
	}

}