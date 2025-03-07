# arr1의 행을 arr 열과 곱해서 넣기
def solution(arr1, arr2):
    answer = []
    
    # arr1 행에 대해서
    for i in range(len(arr1)):
        products = []
        
        # arr2 열에 대해서
        for j in range(len(arr2[0])):
            p = 0
            # arr2 행에 대해서
            for k in range(len(arr2)):
                p += arr1[i][k] * arr2[k][j]
            products.append(p)
        answer.append(products)
            
    return answer