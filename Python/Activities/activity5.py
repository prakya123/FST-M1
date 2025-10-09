# Multiplication Table Program

# Ask the user for a number
num = int(input("Enter a number: "))

# Use a loop to print the multiplication table
print(f"\nMultiplication Table of {num}:")
for i in range(1, 11):
    print(f"{num} x {i} = {num * i}")
