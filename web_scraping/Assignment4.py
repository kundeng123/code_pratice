from random import randint
import statistics


class ParticipantData:
    def __init__(self, id, firstName, lastName, age, className):
        self.id = id
        self.firstName = firstName
        self.lastName = lastName
        self.age = age
        self.className = className

    def getName(self):
        return "Name: " + self.firstName + " " + self.lastName

    def getClassName(self):
        return self.className

def mergeFile(listOfFile):
    result = []

    for item in listOfFile:
        result.append(item.getName())
    print(set(result))

def mergeFile2(listOfFile):
    result = {}
    for item in listOfFiles:

        if item.getName() in result:
            result[item.getName()] += 1
        else:
            result[item.getName()] = 1

    for i in result:
        print(i + ", # of class taken " + str(result[i]))

def sumOfScores(name, scores):
    scores.sort()
    print("Student Name: " + name)
    print("Total points for eight highest-scoring quizzes: ",  sum(scores[2:]))

def printMedianAndMean(name, scores):
    scores.sort()
    print(scores)
    print("Student Name: " + name)
    print("Median:", statistics.median(scores[2:]), "; Mean:", statistics.mean(scores[2:]))


fileA = ParticipantData(1,"A", "B", 10, "swim")
fileB = ParticipantData(2,"C", "D", 8, "tennis")
fileC = ParticipantData(3,"E","F",12,"swim")
fileD = ParticipantData(4,"A", "B", 10, "tennis")
fileE = ParticipantData(5,"G","H", 9, "math")
fileF = ParticipantData(6,"G","H", 9, "swim")
fileG = ParticipantData(7,"G","H", 9, "tennis")

listOfFiles = []
listOfFiles.append(fileA)
listOfFiles.append(fileB)
listOfFiles.append(fileC)
listOfFiles.append(fileD)
listOfFiles.append(fileE)
listOfFiles.append(fileF)
listOfFiles.append(fileG)

#mergeFile(listOfFiles)
#mergeFile2(listOfFiles)


listOfScores = []
for _ in range(10):
    listOfScores.append(randint(60,100))

print(listOfScores)
sumOfScores("David", listOfScores)
printMedianAndMean("David", listOfScores)