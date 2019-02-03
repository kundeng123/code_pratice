def dot_product(item1, item2):
    if not item1 or not item2 or len(item1) != len(item2):
        return 0
    result = 0
    for num1, num2 in zip(item1, item2):
        print(num1)
        print(num2)
        result += num1* num2

    #using python's way to get dot product
    print(sum([i*j for i,j in zip(item1, item2)]))

    return result

a = [1,2,3]
b = [4,5,6]
print(dot_product(a,b))