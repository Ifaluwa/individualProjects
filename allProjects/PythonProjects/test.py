import re
import os


def reverseString(string):
	new = ""
	size = len(string)
	index = size - 1

	for i in range(0, size):
		new += string[index]
		index -= 1

	print new








if __name__ == '__main__':
	test = "esion"
	reverseString(test)