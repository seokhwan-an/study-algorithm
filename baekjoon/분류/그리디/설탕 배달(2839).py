sugar = int(input())
Box = 0
while True:
    if sugar % 5 == 0:
        Box = Box + sugar//5
        print(Box)
        break
    sugar = sugar-3
    Box += 1
    if sugar < 0:
        print(-1)
        break