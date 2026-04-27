from pyspark.context import SparkContext
from pyspark.sql.session import SparkSession
sc=SparkContext.getOrCreate()
spark=SparkSession(sc)

rdd1=sc.parallelize([("spark",1),("hadoop",4)])
rdd2=sc.parallelize([("spark",2),("hadoop",5)])

rdd=sorted(rdd1.join(rdd2).collect())

print(rdd)