def printSummaryRating():
    movieNameList = []
    movieName = str(input("please enter a movie name for rating: "))
    while  movieName != "ZZZZZ":
        movieNameList.append(movieName)
        movieName = str(input("please enter a movie name for rating: "))

    for movie in movieNameList:
        hollywoodMovieRating(movie)


def hollywoodMovieRating(movieName):
    result = 0
    count = 0
    userInput = 0
    while userInput >= 0:
        
        userInput = int(input("please rate movie {}, value from 0 to 4: ".format(movieName)))
        while userInput not in range(0,5) and userInput > 0:
            print("Value incorrect, please try again...")
            userInput = int(input("please rate a movie of the week, value from 0 to 4: "))
            if userInput < 0:
                break
        if userInput < 0:
            break
        count +=1
        result += userInput
    print("Average star for the movie {}: {}".format(movieName, result/count))



printSummaryRating()
