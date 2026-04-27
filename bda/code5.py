from google.colab import files
uploaded = files.upload()

from pyspark.sql import SparkSession
spark=SparkSession.builder.appName("word_count"). getOrCreate()

text_file = spark.read.text("txtt.txt")
words = text_file.rdd.flatMap(lambda line: line.value.split(" "))
word_count = words.count()
print("Number of words in text file: ", word_count)