def max_subarray(array):
	maxhere = 0
	maxfar = 0
	liste = [float(x) for x in array]
	print(liste)

	





if __name__ == "__main__":
	with open('testfiles', 'r') as test_cases:
		for test in test_cases:
			a = test.strip()
			b = a.split(',')
			max_subarray(b)