def sevensRecursion(x,y):
    if y!=0:
        return sevensRecursion((x*7),(y-1))
    else:
        print(str(digit_sum(x)) + " " + str(digit_sum(digit_sum(digit_sum(x)))) + " " + str(x))
        
def digit_sum(n):
    num_str = str(n)
    sum = 0
    for i in range(0, len(num_str)):
        sum += int(num_str[i])
    return sum
        
        
def iteratorMain():
    for i in range(0,21):
        sevensRecursion(7,i)
        
iteratorMain()
