import pytest

# Fixture to create a list of numbers 0–10
@pytest.fixture
def number_list():
    return list(range(11))

# Test to check if the sum of the list is 55
def test_sum_of_list(number_list):
    assert sum(number_list) == 55
