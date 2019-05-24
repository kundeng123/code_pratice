import math

class Circle():
    def __init__(self):
        self.radius = 1
        self.area = None
        self.diameter = None

    def getRadius(self):
        return self.radius
    def getArea(self):
        return self.area
    def getDiameter(self):
        return self.diameter

    def setRadius(self, radius):

        if radius > 0:
                self.radius = radius
                self.diameter = 2 * self.radius
                self.area = math.pi * self.radius * self.radius
        else:
            print("Radius cannot be zero or negative value.")

    def display(self):
        if not self.diameter or not self.area:
            self.diameter = 2 * self.radius
            self.area = math.pi * self.radius * self.radius
        print("Circle's info:")
        print("Radius: " + str(self.radius) + " Diameter: " + str(self.diameter) + " Area: " + str(self.area))



class Player():
    def __init__(self,number=None,name = None):
        self.number = number
        self.name = name
    def setNumber(self, number):
        self.number = number
    def setName(self, name):
        self.name = name

    def getNumber(self):
        return self.number
    def getName(self):
        return self.name
    def display(self):
        print("Number: " + str(self.number) +" Name: " + str(self.name))

class BaseballPlayer(Player):
    def __init__(self, number1=None,name1 = None, position=None, average = None):
        self.position = position
        self.average = average
        Player.__init__(self,number1, name1)

    def display(self):
        print("Number: " + str(self.number) + " Name: " + str(self.name)
              + " Position: " + str(self.position) + " Average: " + str(self.average))

class BasketballPlayer(Player):
    def __init__(self, number=None,name = None, position=None, percentage = None):
        self.position = position
        self.percentage = percentage
        Player.__init__(self, number, name)

    def display(self):
        print("Number: " + str(self.number) + " Name: " + str(self.name)
              + " Position: " + str(self.position) + " Free-throw percentage: " + str(self.percentage))

player1 = Player("player-123", "David")
player1.display()


baseballPlayer = BaseballPlayer( "baseball-1", "Jack","1", "10")
baseballPlayer.display()

basketballPlayer = BasketballPlayer("basketball-1", "Molly", "2", "0.5")
basketballPlayer.display()