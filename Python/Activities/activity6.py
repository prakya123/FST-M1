# activity6.py
# Pattern Generator using Nested Loops

# Outer loop for rows
for i in range(1, 10):
    # Inner loop for printing numbers in each row
    for j in range(i):
        print(i, end="")
    print()  # Move to the next line after each row
