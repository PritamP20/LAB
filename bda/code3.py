from pyspark import SparkContext
sc = SparkContext()

rdd = sc.parallelize([{1, 2, 3}, {4, 5, 6}, {7, 8, 9}])
acc = sc.accumulator(0)
def add_to_acc(x):
 global acc
 acc += sum(x)
 rdd.foreach(add_to_acc)
 print("Sum of numbers in RDD: ", acc.value)
 sc.stop()
