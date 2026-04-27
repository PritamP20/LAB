from pyspark.sql import SparkSession
from pyspark.sql import Row
from pyspark.sql.types import StructType, StructField, StringType, IntegerType
from pyspark.sql.functions import col, sum ,avg,max,min

spark = SparkSession.builder.appName("StatewiseSalary").getOrCreate()

schema = ["employee_name","department","state","salary","age","bonus"]
rdd = spark.sparkContext.parallelize(data)
print(rdd.take(5))

df = spark.createDataFrame(rdd, schema)
df.show()
result = df.groupBy("state").sum("salary")
filtered_result = result.filter("sum(salary) > 100000")
final_result = filtered_result.orderBy("sum(salary)", ascending=False)
final_result.show()
