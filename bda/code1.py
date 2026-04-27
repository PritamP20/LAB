from pyspark import SparkContext
sc = SparkContext()
rdd = sc.parallelize(["scala", "java", "hadoop", "spark", "akka", "spark vs hadoop","pyspark", "pyspark and spark"])
total_count = rdd.count()
print("word count is %d" %(total_count))
spark_words_rdd = rdd.filter(lambda x: "spark" in x)
spark_words = spark_words_rdd.collect()
print("Filtered rdd : %s" %(spark_words))