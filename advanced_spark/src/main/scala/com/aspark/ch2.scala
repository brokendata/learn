package com.aspark

/**
 * Created by ryan on 12/15/14.
 */

/*

Data is structured in the form of multiple files. First row is header followed by data



$SPARK_HOME/bin/spark-submit --class com.july.ListCombine /home/ryan/proj/july/target/scala-2.10/july_2.10-1.0.jar

*/

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.serializer.KryoRegistrator
import com.aspark.functions._
import com.esotericsoftware.kryo.Kryo


class ch2 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("ch2 party")
    conf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    conf.set("spark.kryo.registrator", "mypackage.MyRegistrator")
    val sc = new SparkContext("local", "ch2")

    //Begin Processing
    val rawdata = sc.textFile("resources/block_1.csv")
    val mds = rawdata.filter(!isHeader(_)).map(parse)





  }


}
