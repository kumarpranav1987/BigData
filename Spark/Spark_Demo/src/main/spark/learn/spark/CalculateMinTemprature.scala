package learn.spark

import org.apache.spark.SparkContext

object CalculateMinTemprature {
  def main(args: Array[String]): Unit = {
    val sc = new SparkContext("local[*]", "MinTemprature")
    val rdd = sc.textFile("1800.csv").filter { x => { x.split(",")(2) == "TMIN" } }.map { x => { (x.split(",")(0), x.split(",")(3).toInt) } }.reduceByKey((x, y) => { Math.min(x, y) });
    rdd.foreach(println)
  }
}