def solution(n, arr1, arr2):
    answer = []
    map1 = []
    map2 = []
    for i in range(n):
        data1 = str(bin(arr1[i]))[2:]
        data2 = str(bin(arr2[i]))[2:]
        if len(data1) < n:
            data1 = '0'*(n-len(data1)) + data1
        if len(data2) < n:
            data2 = str('0'*(n-len(data2)) + data2)
        map1.append(data1)
        map2.append(data2)
    for i in range(n):
        k = ""
        for j in range(n):
            if map1[i][j] == '0' and map2[i][j] == '0':
                k += " "
            else:
                k += "#"
        answer.append(k)

    return answer