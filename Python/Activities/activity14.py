# Activity 14: Fibonacci Numbers Using Recursion

def fibonacci(n):
    if n <= 1:
        return n
    else:
        return fibonacci(n-1) + fibonacci(n-2)

# Ask user how many Fibonacci numbers to generate
count = int(input("Activity 14: Enter how many Fibonacci numbers to generate: "))

print("Fibonacci sequence:")
for i in range(count):
    print(fibonacci(i), end=" ")
