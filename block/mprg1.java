import pandas as pd  
import numpy as np  
import matplotlib.pyplot as plt  

df = pd.read_csv('kc_house_data.csv')  
df = df.drop(['id','date'], axis=1)
y = df['price']

x = df.drop('price', axis=1)  
# Store remaining columns as input features (X)

from sklearn.model_selection import train_test_split  
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=2)  

from sklearn.linear_model import LinearRegression  
reg = LinearRegression().fit(x_train, y_train)  


reg.score(x_test, y_test)  
y_pred = reg.predict(x_test)  

plt.figure(figsize=(8,6))  
plt.scatter(y_test, y_pred)  
plt.plot(y_test, y_test)  
plt.xlabel("Actual House Price")  
plt.ylabel("Predicted House Price")  
plt.title("Actual vs Predicted House Prices")  
plt.show()  