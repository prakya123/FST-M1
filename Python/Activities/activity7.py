# Activity 7: List Sum Calculator

# Ask the user to enter numbers separated by spaces
numbers = input("Enter numbers separated by spaces: ")

# Split the input string into a list of strings, then convert each to an integer
num_list = [int(num) for num in numbers.split()]

# Calculate the sum of the list
total = sum(num_list)

# Display the result
print("The sum of the numbers is:", total)
