from pyspark.sql import SparkSession

spark = SparkSession.builder.appName("RDD and DataFrame Example").getOrCreate()
data = [("1", "john jones"), ("2", "tracey smith"), ("3", "amy sanders")]
columns = ["Seqno", "Name"]
rdd = spark.sparkContext.parallelize(data)

from pyspark.sql import Row
df = rdd.map(lambda x: Row(Seqno=x[0], Name=x[1])).toDF()
df.show()

def capitalize_first_letter(s):
    return s.title() if s else s

from pyspark.sql.functions import udf 
from pyspark.sql.types import StringType
capitalize_udf = udf(capitalize_first_letter, StringType())
df_transformed = df.withColumn("Name", capitalize_udf(df["Name"])) 
df_transformed.show()
 