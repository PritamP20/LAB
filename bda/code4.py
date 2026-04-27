from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("CSV RDD").getOrCreate()
rdd = spark.read.format("csv").option("header", "true").load("/Book1.csv").rdd
print(rdd.take(5))
df = rdd.toDF()
df.describe().show()