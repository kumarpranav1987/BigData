package mapreduce.example.linecount;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class LineReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	@Override
	protected void reduce(Text arg0, Iterable<IntWritable> arg1, Context arg2)
			throws IOException, InterruptedException {
		int numberOfLines = 0;
		for (IntWritable i : arg1) {
			numberOfLines += i.get();
		}
		arg2.write(arg0, new IntWritable(numberOfLines));
	}
}
