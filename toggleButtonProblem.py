#The problem is:
#A light bulb is connected to n switches in such a way that it lights up only when all the switches are closed. Each switch is controlled by a push button; pressing the button toggles the switch, but there is no way to know the state of the switch. Design an algorithm to turn on the light bulb with the minimum number of button pushes needed in the worst case.

import random # to get random number

def toggleButton(array, count): #function (array- array of switches, count- number of toggles)
	#print("array: ", array)
	
	length = len(array) #to get length of an array so we can get random element from array
	temp = random.randint(0, length-1)	#getting random element
	
	#to toggle the switch
	if array[temp] == 0:
		array[temp] = 1
	else:
		array[temp] = 0
	
	#incrementing the toggle count
	count += 1
	
	
	if 1 in array: #to check if any switch is ON (value = 1). Here i have considered 1 = ON/ Opened and 0 = OFF/ Closed
		toggleButton(array, count) #recursively call function
	else:
		print("array: ", array) #printing array just to confirm if all switches are closed
		print("The Number of Toggles: ", count) #printing number of toggles
	
num = int(input("Enter the number of Switches: "))  #input number of switches from user
array = [] #declaration of blank array for storing switch value (open or closed)
count = 0 #number of toggles 
for i in range(num):
	array.append(random.randint(0,1)) #randomly assigning value open/Closed to switches
toggleButton(array, count)	#call the func


#if you want to get the maxmimum number of toggles for worst case, put the call func (line 33) in for loop and call the func multiple times to get different values of toggles. This way the time complexity would be high but so will the accuracy
