def solution(phone_book):
    answer = True
    phone_book.sort()
    
    for i in range(0, len(phone_book) - 1):
        n1 = phone_book[i]
        n2 = phone_book[i + 1]
        
        if n1 in n2 and n1[0] == n2[0]:
            answer = False
            break
    return answer