from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from webdriver_manager.chrome import ChromeDriverManager
import time

# Setup ChromeDriver automatically
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

# Open the training site
driver.get("https://training-support.net")

# Print the page title
print("Title of the page is:", driver.title)

# Wait for About link to be clickable and click
wait = WebDriverWait(driver, 10)
about_link = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "About")))
about_link.click()

# Print the new page title
print("Title after click is:", driver.title)

# Wait a few seconds before closing
time.sleep(3)

driver.quit()
