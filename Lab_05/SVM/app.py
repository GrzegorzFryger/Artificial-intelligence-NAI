import pandas as pd
import seaborn as sns
from sklearn.model_selection import train_test_split
from sklearn.svm import SVC
from sklearn.metrics import classification_report, confusion_matrix

def openFile(filename):
    data = pd.read_csv(filename)

    print("Shape: " + str(data.shape) + "\n")
    print("Had: " + str(data.head) + "\n")

    dataFrame = data.drop('UNS', axis=1)
    result = data['UNS']
    g = sns.pairplot(data, hue='UNS')
    return dataFrame, result


def splitDataToTrainAndTest(data, result):
    dataFrameTrain, dataFrameTest, resultTrain, resultTest = train_test_split(data, result, test_size=0.20)
    return dataFrameTrain, dataFrameTest, resultTrain, resultTest


def predictData(dataCol, resultCol, typeSVM):
    dataFrameTrain, dataFrameTest, resultTrain, resultTest = splitDataToTrainAndTest(dataCol, resultCol)
    svcType = SVC(kernel=typeSVM)
    svcType.fit(dataFrameTrain, resultTrain)
    resultPredict = svcType.predict(dataFrameTest)

    print('------------------' + str(typeSVM) + '--------------------------')
    print('Test data')
    print(dataFrameTest)
    print('result predicted')
    print(str(resultPredict))
    print(confusion_matrix(resultTest, resultPredict))
    print(classification_report(resultTest, resultPredict))
    print('------------------' + str(typeSVM) + '--------------------------')


def main():
    data, result = openFile("data4.csv")
    predictData(data, result, 'rbf')
    predictData(data, result, 'poly')
    predictData(data, result, 'sigmoid')


if __name__ == "__main__":
    main()
