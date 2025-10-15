# Activities 17 & 18 - Writing and Reading CSV Files

# Import pandas
import pandas as pd

# ------------------ Activity 17: Writing CSV Files ------------------

# Create a dictionary with usernames and passwords
data = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charli3", "AllMight"]
}

# Create a DataFrame using the data
dataframe = pd.DataFrame(data)

# Print the DataFrame
print("Original DataFrame:")
print(dataframe)

# Write the DataFrame to a CSV file
dataframe.to_csv("sample.csv", index=False)
print("\nCSV file 'sample.csv' created successfully!\n")

# ------------------ Activity 18: Reading CSV Files ------------------

# Read the CSV file created above
df = pd.read_csv("sample.csv")

print("Data read from CSV file:")
print(df)

# Print only the values in the Usernames column
print("\nUsernames column:")
print(df["Usernames"])

# Print the username and password of the second row
print("\nSecond row details:")
print("Username:", df.loc[1, "Usernames"])
print("Password:", df.loc[1, "Passwords"])

# Sort Usernames column in ascending order and print
print("\nUsernames sorted in ascending order:")
print(df.sort_values("Usernames"))

# Sort Passwords column in descending order and print
print("\nPasswords sorted in descending order:")
print(df.sort_values("Passwords", ascending=False))
