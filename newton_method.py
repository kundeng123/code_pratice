import math

def newtonMethod( number):
    if number < 0:
        return 0
    else:
        # y = x^2 - number

        x = number/2
        x1 = x - (x * x - number) / (2 * x)

        while abs(x - x1) >= 0.00000000001:

            x = x1
            x1 = x - (x * x - number) / (2 * x)
            #print(x)
    return x1

print(newtonMethod(2))
print("result ", math.sqrt(2))