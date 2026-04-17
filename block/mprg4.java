import numpy as np  
import pandas as pd
from sklearn.preprocessing import LabelEncoder  
from sklearn.metrics import accuracy_score  
from sklearn.model_selection import train_test_split  
from sklearn.svm import SVC  
from sklearn.metrics import confusion_matrix, classification_report  
import matplotlib.pyplot as plt  

df = pd.read_csv("smaller_adult.csv")  
df.replace('?', np.nan, inplace=True)  
df.dropna(inplace=True)  
df.drop_duplicates(inplace=True)  
X = df[['age','workclass','educational-num','occupation','gender','hours-per-week']]  
y = LabelEncoder().fit_transform(df['income'])  
X = pd.get_dummies(X)  
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.33, random_state=20)  

clf = SVC(kernel="linear")  
clf.fit(X_train, y_train)  
y_pred = clf.predict(X_test)  
print("Accuracy:", accuracy_score(y_test, y_pred))  

cm = confusion_matrix(y_test, y_pred)  
import seaborn as sns  
sns.heatmap(cm, annot=True)  