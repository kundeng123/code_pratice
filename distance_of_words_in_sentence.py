def solution(sentence,start,end):
    startIndex = -1


    countOfSpace = 0
    list_of_words = sentence.split(' ')
    endIndex = len(list_of_words) + 1
    minDistance = len(sentence)

    print(list_of_words)

    for i in range(len(list_of_words)):
        '''
        if i != 0:
            countOfSpace = countOfSpace + 1
        if list_of_words[i] == start :
            if i < endIndex :
                startIndex = max(startIndex,i)
        #print(list_of_words[len(list_of_words) - i - 1])
        if list_of_words[len(list_of_words) - i - 1] == end:

            if (len(list_of_words) - i - 1) > startIndex :
                endIndex = min(endIndex,(len(list_of_words) - i - 1))
        '''
        if list_of_words[i] == start:
            startIndex = i
        if list_of_words[i] == end:
            endIndex = i
        if startIndex != -1 and endIndex != len(list_of_words) + 1:
            #print("st ", startIndex)
            #print("end ", endIndex)

            if minDistance > endIndex - startIndex and startIndex < endIndex:
                minDistance = endIndex - startIndex
            #print("min ", minDistance)



    #print("startIndex ", startIndex)
    #print("endIndex ", endIndex)

    if endIndex == len(list_of_words) + 1 or minDistance == len(sentence):
        return -1
    elif startIndex == -1:
        return -1
    else:
        return minDistance
print(solution("hello rld hello sdfg world hello", "hello", "world"))
print(solution("world hello world", "hello", "world"))

