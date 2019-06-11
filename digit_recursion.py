def main():
	for digit in range(100,1000):
		#recursive_add(digit,digit)	
		recursive_multiply(digit,digit)
def recursive_add(number, iteration):
	i = iteration
	current = str(number)
	if(len(current)==1):
		print(str(iteration) + "|" + current)
		return
	else:
		sum = 0
		for digit in range(0,len(current)):
			sum+=int(current[digit])
		return recursive_add(sum, i) #switching to recursive_multiply creates coherent pattern
def recursive_multiply(number, iteration):
	i = iteration
	current = str(number)
	if(len(current)==1):
		print(str(iteration) + "|" + current)
		return
	else:
		product = 1
		for digit in range(0,len(current)):
			if(int(current[digit])!=0):
				product*=int(current[digit])
		return recursive_multiply(product, i) #switching to recursive_add creates coherent pattern
main()