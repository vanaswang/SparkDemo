package com.vanas.bigdata.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark04_RDD_Memory_PartitionData {
    def main(args: Array[String]): Unit = {


        // Spark
        //1.泛型
        //def parallelize[T: ClassTag](
        //seq: Seq[T],
        //numSlices: Int = defaultParallelism): RDD[T] = withScope {
        //assertNotStopped()
        //new ParallelCollectionRDD[T](this, seq, numSlices, Map[Int, Seq[String]]())
        //}

        //2.方法重写
        //override def getPartitions: Array[Partition] = {
        //val slices = ParallelCollectionRDD.slice(data, numSlices).toArray
        //slices.indices.map(i => new ParallelCollectionPartition(id, i, slices(i))).toArray
        //}

        //3.伴生对象
        //4.模式匹配  def slice=>seq match
        //5.map
//        def slice[T: ClassTag](seq: Seq[T], numSlices: Int): Seq[Seq[T]] = {
//            if (numSlices < 1) {
//                throw new IllegalArgumentException("Positive number of partitions required")
//            }
//            // Sequences need to be sliced at the same set of index positions for operations
//            // like RDD.zip() to behave as expected
//            def positions(length: Long, numSlices: Int): Iterator[(Int, Int)] = {
//                (0 until numSlices).iterator.map { i =>
//                    val start = ((i * length) / numSlices).toInt
//                    val end = (((i + 1) * length) / numSlices).toInt
//                    (start, end)
//                }
//            }
//            seq match {
//                case r: Range =>
//                    positions(r.length, numSlices).zipWithIndex.map { case ((start, end), index) =>
//                        // If the range is inclusive, use inclusive range for the last slice
//                        if (r.isInclusive && index == numSlices - 1) {
//                            new Range.Inclusive(r.start + start * r.step, r.end, r.step)
//                        }
//                        else {
//                            new Range(r.start + start * r.step, r.start + end * r.step, r.step)
//                        }
//                    }.toSeq.asInstanceOf[Seq[Seq[T]]]
//                case nr: NumericRange[_] =>
//                    // For ranges of Long, Double, BigInteger, etc
//                    val slices = new ArrayBuffer[Seq[T]](numSlices)
//                    var r = nr
//                    for ((start, end) <- positions(nr.length, numSlices)) {
//                        val sliceSize = end - start
//                        slices += r.take(sliceSize).asInstanceOf[Seq[T]]
//                        r = r.drop(sliceSize)
//                    }
//                    slices
//                case _ =>
//                    val array = seq.toArray // To prevent O(n^2) operations for List etc
//                    positions(array.length, numSlices).map { case (start, end) =>
//                        array.slice(start, end).toSeq
//                    }.toSeq
//            }
//        }


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)

        //内存中的集合数据按照平均分的方式进行分区处理
        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
        rdd.saveAsTextFile("output")
        //12，34

        val rdd1: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 4)
        rdd1.saveAsTextFile("output1")
        //1，2，3，4
        //savaAsTextFile方法如果文件路径已经存在，会发生错误
        //内存中的集合数据如果不能平均分，会将多余的数据放置在最后一个分区
        //内存中数据的分区基本上就是平均分，如果不能够整除，会采用一个基本的算法实现分配

        //List(1, 2, 3, 4,5)=>Array(1,2,3,4,5)
        // (length=5,num=3)
        //(0,1,2)
        //=>0 =>(0,1) =>1
        //=>1 =>(1,3) =>2
        //=>2 =>(3,5) =>
        //Array.slice=>切分数组=>(from,until)
        val rdd2: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 3)
        rdd2.saveAsTextFile("output2")
        //1，2，34
        //1，23，45
        sc.stop()
    }

}
