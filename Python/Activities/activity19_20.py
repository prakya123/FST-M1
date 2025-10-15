import pandas as pd

# ---------- Activity 19: Writing Excel Files ----------
data = {
    'FirstName': ['Satvik', 'Avinash', 'Lahri'],
    'LastName': ['Shah', 'Kati', 'Rath'],
    'Email': ['satshah@example.com', 'avinashk@example.com', 'lahri.rath@example.com'],
    'PhoneNumber': [4537829158, 5892184058, 4528727830]
}

# Create DataFrame
df = pd.DataFrame(data)

# Write to Excel file
excel_file = 'Activity19_20.xlsx'
df.to_excel(excel_file, index=False)

print("Excel file created successfully!\n")

# ---------- Activity 20: Reading Excel Files ----------
# Read the data from Excel file
df_read = pd.read_excel(excel_file)

# Print number of rows and columns
rows, cols = df_read.shape
print(f"Number of rows: {rows}")
print(f"Number of columns: {cols}\n")

# Print the data in the 'Email' column only
print("Emails column data:")
print(df_read['Email'], "\n")

# Sort the data by 'FirstName' in ascending order and print
sorted_df = df_read.sort_values(by='FirstName')
print("Data sorted by FirstName (ascending):")
print(sorted_df)
