# Activity 10 - Tuple Number Checker

# Ask the user to enter numbers separated by spaces
user_input = input("Enter numbers for the tuple (separated by spaces): ")

# Convert the input into a tuple of integers
numbers = tuple(map(int, user_input.split()))

print("Numbers divisible by 5 are:")

# Check and print numbers divisible by 5
for num in numbers:
    if num % 5 == 0:
        print(num)
