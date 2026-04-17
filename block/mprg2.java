import pandas as pd  
from sklearn.datasets import load_diabetes
from sklearn.model_selection import train_test_split  
from sklearn.linear_model import LogisticRegression  
from sklearn.preprocessing import StandardScaler  
import matplotlib.pyplot as plt  
from sklearn.metrics import accuracy_score, confusion_matrix  
import numpy as np  
import seaborn as sns  

diabetes = load_diabetes()
x, y = diabetes.data, diabetes.target  
y_binary = (y > np.median(y)).astype(int)  
x_train, x_test, y_train, y_test = train_test_split(x, y_binary, test_size=0.2, random_state=44)  

scaler = StandardScaler()  
x_train = scaler.fit_transform(x_train)  
x_test = scaler.transform(x_test)  
model = LogisticRegression()  
model.fit(x_train, y_train)  
y_pred = model.predict(x_test)  

accuracy = accuracy_score(y_test, y_pred)  
print(confusion_matrix(y_test, y_pred))  

plt.figure(figsize=(8,6))  
sns.scatterplot(x=x_test[:, 2], y=x_test[:, 8], hue=y_test)  
plt.title("Logistic Regression Decision Boundary")  
plt.show()  