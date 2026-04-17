import numpy as np  
import pandas as pd  
data = pd.read_csv("breast-cancer-wisconsin-data_data.csv")  

data = data.drop(['id', 'Unnamed: 32'], axis=1)  
X = data.drop('diagnosis', axis=1)
y = data['diagnosis']  


from sklearn.model_selection import train_test_split  
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=42)  

from sklearn.neighbors import KNeighborsClassifier  
knn = KNeighborsClassifier(n_neighbors=3)  
knn.fit(X_train, y_train)  
y_pred = knn.predict(X_test)  

from sklearn.metrics import accuracy_score  
print(accuracy_score(y_test, y_pred))