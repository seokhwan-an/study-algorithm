import math
from functools import reduce

def solution(arrayA, arrayB):
    answer = 0
    
    a_gcd = get_gcd(arrayA)
    a = find_max_number(arrayB, a_gcd)
    
    b_gcd = get_gcd(arrayB)
    b = find_max_number(arrayA, b_gcd)
    
    answer = max(a, b)
    
    
    return answer

def get_gcd(array):
    return reduce(math.gcd, array)

def find_max_number(array, num):
    nums = [i for i in range(1, num + 1) if num % i == 0]
    nums.sort(reverse = True)

    for num in nums:
        for i in array:
            if i % num == 0:
                break
        else:
            return num
    return 0
                