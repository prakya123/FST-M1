import pytest

# --- Calculator functions ---
def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    if b == 0:
        raise ValueError("Cannot divide by zero")
    return a / b


# --- Activity 21: Tests for calculator operations ---
def test_sum_of_two_numbers():
    assert add(10, 5) == 15

def test_difference_of_two_numbers():
    assert subtract(10, 5) == 5


# --- Activity 22: Apply marker 'activity' to last 2 tests ---
@pytest.mark.activity
def test_product_of_two_numbers():
    assert multiply(4, 3) == 12

@pytest.mark.activity
def test_quotient_of_two_numbers():
    assert divide(10, 2) == 5

