import numpy as np  
import pandas as pd 
from sklearn.preprocessing import LabelEncoder  
from sklearn.model_selection import train_test_split  
from sklearn.tree import DecisionTreeClassifier, plot_tree  
from sklearn.metrics import accuracy_score, confusion_matrix, classification_report  
import matplotlib.pyplot as plt  

df = pd.read_csv("adult.csv")  
df.replace('?', np.nan, inplace=True)  
df.dropna(inplace=True)  
X = df.drop('income', axis=1)  
y = LabelEncoder().fit_transform(df['income'])  
X = pd.get_dummies(X)  
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=2)  
clf = DecisionTreeClassifier(max_depth=5)  
clf.fit(X_train, y_train)  
y_pred = clf.predict(X_test)  
print("Accuracy:", accuracy_score(y_test, y_pred))  

plt.figure(figsize=(14,14))  
plot_tree(clf, filled=True)  
plt.show()  