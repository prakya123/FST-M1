# Activity 11 - Fruit Shop

# Create a dictionary of fruits and their prices
fruit_shop = {
    "apple": 100,
    "banana": 40,
    "orange": 60,
    "mango": 120,
    "grapes": 80
}

# Ask user to enter the fruit name
fruit = input("Enter the name of the fruit you want: ").lower()

# Check if the fruit is available
if fruit in fruit_shop:
    print(f"Yes, {fruit} is available. Price: ₹{fruit_shop[fruit]}")
else:
    print(f"Sorry, {fruit} is not available.")
