from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
import time

def main():
    # Setup Chrome driver automatically
    service = Service(ChromeDriverManager().install())
    driver = webdriver.Chrome(service=service)

    try:
        # 1. Open the URL
        driver.get("https://training-support.net/webelements/login-form/")

        # 2. Get and print the title
        print("Page title:", driver.title)

        # 3. Find username field and enter "admin"
        username = driver.find_element(By.ID, "username")
        username.send_keys("admin")

        # 4. Find password field and enter "password"
        password = driver.find_element(By.ID, "password")
        password.send_keys("password")

        # 5. Find and click the "Log in" button
        login_btn = driver.find_element(By.XPATH, "//button[text()='Log in']")
        login_btn.click()

        # small pause so you can see result
        time.sleep(2)

    except Exception as e:
        print("Error:", e)
    finally:
        # 6. Close the browser
        driver.quit()

if __name__ == "__main__":
    main()
