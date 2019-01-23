def findHighestAverage(pointsAndNames):
    nameMap = {}

    for pairs in pointsAndNames:
        #print(pairs)
        if pairs[0] not in nameMap:
            nameMap.update({pairs[0]:[pairs[1]]})
        else:
            nameMap[pairs[0]].append(pairs[1])


    maxAverage = -float('inf')

    for key in nameMap:
        print(nameMap[key])
        if sum(nameMap[key])/len(nameMap[key]) > maxAverage :
            maxAverage = sum(nameMap[key])/len(nameMap[key])

    #print(maxAverage)

    return maxAverage


pair1 = ["aa", -100]
pair2 = ["bb", -88]
pair3 = ["cc", -90]
pair4 = ["aa", -5]
pair5 = ["dd", -19]


listOfPair = []
listOfPair.append(pair1)
listOfPair.append(pair2)
listOfPair.append(pair3)
listOfPair.append(pair4)
listOfPair.append(pair5)

print(findHighestAverage(listOfPair))