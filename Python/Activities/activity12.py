# Activity 12 - Recursive Adder

# Recursive function to calculate sum from 0 to n
def recursive_sum(n):
    if n == 0:
        return 0
    else:
        return n + recursive_sum(n - 1)

# Call the function for numbers 0 to 10
result = recursive_sum(10)

print("Sum of numbers from 0 to 10 is:", result)

