import datetime

class PerformArithmetic():
    def __init__(self):
        self.num1 = 0
        self.num2 = 0

    def setInputNumbers(self):
        print("Please enter two numeric values: ")
        self.num1 = int(input("Number 1: "))
        self.num2 = int(input("Number 2: "))

    def sum(self):
        print("Sum of two numbers is: " + str(self.num1 + self.num2))

    def difference(self):
        print("Difference of two numbers is: " + str(abs(self.num1 -self.num2)))

    def product(self):
        return self.num2 * self.num1


class CalcDate():
    def __init__(self):
        self.month = 0
        self.day = 0
        self.year = 0
    def setDate(self):
        self.month = input("please enter month: ")
        self.day  = input("please enter day: ")
        self.year = input("please enter year: ")
        try:
            date = datetime.datetime.strptime(self.month + "/" + self.day + "/" + self.year, "%m/%d/%Y")
        except ValueError:
            print("Wrong date format")

    def displayDate(self):
        print("Date: " + self.month + "/" + self.day + "/" + self.year)
    def displayDueDate(self):
        start_date =  self.month + "/" + self.day + "/" + self.year
        currentDate = datetime.datetime.strptime(start_date, "%m/%d/%Y")
        dueDate = currentDate + datetime.timedelta(days=10)
        print("Due date is: " + dueDate.strftime("%m/%d/%Y"))

class ReverseInput():
    def __init__(self):
        self.list = []
        for i in range(5):
            self.list.append(input("Please enter a number: "))

    def reverse(self):
        print("reversed list: "+ str(self.list[::-1]))

res = ReverseInput()
res.reverse()