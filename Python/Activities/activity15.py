# Activity 15: Handling Errors

try:
    # Define 'x' before using it
    x = "Hello, World!"
    print(x)
except NameError:
    print("Activity 15: A NameError occurred — variable is not defined.")
finally:
    print("Program continues running smoothly!")
