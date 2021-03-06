
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import warnings
import numpy as np
import matplotlib.pyplot as plt
import warnings

from google.colab import files
from pathlib import Path
from sklearn.metrics import accuracy_score
from sklearn.metrics import classification_report, confusion_matrix
from keras.models import Sequential
from keras.layers import Dense
from keras.optimizers import Adam
from sklearn.model_selection import train_test_split

def replaceClassificationNameIntoEnumerated(rawData):
    label_names = rawData['class'].unique()
    index_and_label = list(enumerate(label_names))
    label_to_index = dict((label, index) for index, label in index_and_label)
    return rawData.replace(label_to_index)


def printStatisticsData(raw_data):
    print(raw_data.describe())

    print("")
    print("class distribution")
    print(raw_data.groupby('class').size())

    print(raw_data.head())
    print(raw_data['class'].value_counts())

    sns.set_style("whitegrid");
    sns.pairplot(raw_data, hue='class', size=3);
    plt.show()

def printCostPlot(iteration, fit):
    plt.figure(figsize=(8,6))
    plt.plot(range(1, iteration + 1), fit.history['loss'])
    plt.plot(range(1, iteration +1 ), fit.history['acc'])
    plt.show()

def main():
    warnings.filterwarnings("ignore")
    # Load file
    input_file_name = "iris2.csv"
    if not Path(input_file_name).is_file():
        input_file = files.upload()
        #input_file = pd.read_csv(input_file_name)

    rawData = pd.read_csv(input_file_name, sep=',')

    # Print staticic plots
    printStatisticsData(rawData)

    # Transform names into numbers
    rawData = replaceClassificationNameIntoEnumerated(rawData)

    # Remove class col
    x = rawData.iloc[:, 0:-1]
    # Get only class col
    y_ = rawData.iloc[:, -1:]

    # Split data to test and train
    train_x, test_x, train_y, test_y = train_test_split(x, y_, test_size=0.20)

    # Build the model
    # Model1
   
    model_one = Sequential( name="MODEL1")
    model_one.add(Dense(8, input_shape=(4,), activation='relu'))
    model_one.add(Dense(8, activation='relu'))
    model_one.add(Dense(3, activation='softmax'))

    # Model2
    model_two = Sequential(name="MODEL2")
    model_two.add(Dense(12, input_shape=(4,), activation='relu'))
    model_two.add(Dense(12, activation='relu'))
    model_two.add(Dense(12, activation='relu'))
    model_two.add(Dense(12, activation='relu'))
    model_two.add(Dense(12, activation='relu'))
    model_two.add(Dense(3, activation='softmax'))

    # Model3
    model_three = Sequential(name="MODEL3")
    model_three.add(Dense(8, input_shape=(4,), activation='relu', name='fc1'))
    model_three.add(Dense(8, activation='relu'))
    model_three.add(Dense(8, activation='relu'))
    model_three.add(Dense(8, activation='relu'))
    model_three.add(Dense(8, activation='relu'))
    model_three.add(Dense(8, activation='relu'))
    model_three.add(Dense(3, activation='softmax'))

    model_one.compile(optimizer='Adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
    model_two.compile(optimizer='Adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
    model_three.compile(optimizer='Adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])

    # Training  process
    

    data_train1 = model_one.fit(train_x, train_y, verbose=0, batch_size=5, epochs=100)
    model_one_loss, model_one_acc  = model_one.evaluate(test_x, test_y)
    print(model_one.summary())
    print('Model 1 result loss: {:4f}'.format(model_one_loss))
    print('Model 1 final accuracy: {:4f}'.format(model_one_acc))
    printCostPlot(100,data_train1)

    data_train2 = model_two.fit(train_x, train_y, verbose=0, batch_size=5, epochs=100)
    model_two_loss, model_two_acc  = model_two.evaluate(test_x, test_y)
    print(model_two.summary())
    print('Model 2 result loss: {:4f}'.format(model_two_loss))
    print('Model 2 final accuracy: {:4f}'.format(model_two_acc))
    printCostPlot(100,data_train2)

    data_train3= model_three.fit(train_x, train_y, verbose=0, batch_size=5, epochs=100)
    model_three_loss, model_three_acc  = model_three.evaluate(test_x, test_y)
    print(model_three.summary())
    print('Model 3 result loss: {:4f}'.format(model_three_loss))
    print('Model 3 final accuracy: {:4f}'.format(model_three_acc))
    printCostPlot(100,data_train3)

    # Predict data
    predic1 = model_one.predict(np.array([[6.3, 2.7, 4.9, 1.8]]))
    predic2 = model_two.predict(np.array([[6.3, 2.7, 4.9, 1.8]]))
    predic3 = model_three.predict(np.array([[6.3, 2.7, 4.9, 1.8]]))

    print('------------------' + "Predict data" + '--------------------------')
    np.set_printoptions(formatter={'float': lambda x: "{0:0.2f}".format(x)})
    print('Model 1 result predict:' + str(predic1))
    print('Model 2 final predict:' + str(predic2))
    print('Model 3 final predict:' + str(predic3))


if __name__ == "__main__":
    main()
