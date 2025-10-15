# test_calculator.py
import sys
import os

# Add parent directory to path if files are in separate folders
sys.path.append(os.path.dirname(os.path.dirname(__file__)))

import calculator


def test_sum_of_two_numbers():
    assert calculator.add(10, 5) == 15

def test_difference_of_two_numbers():
    assert calculator.subtract(10, 5) == 5

def test_product_of_two_numbers():
    assert calculator.multiply(4, 3) == 12

def test_quotient_of_two_numbers():
    assert calculator.divide(20, 4) == 5
