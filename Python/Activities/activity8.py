# Activity 8 - List Checker

# Ask user to enter numbers separated by spaces
user_input = input("Enter numbers separated by spaces: ")

# Convert the input string into a list of integers
numbers = list(map(int, user_input.split()))

# Check if first and last numbers are the same
if numbers[0] == numbers[-1]:
    print(True)
else:
    print(False)
