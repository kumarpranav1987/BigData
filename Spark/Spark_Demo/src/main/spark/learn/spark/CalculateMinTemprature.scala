package learn.spark

import org.apache.spark.SparkContext

object CalculateMinTemprature {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]","MinTemprature");
    
  }
}