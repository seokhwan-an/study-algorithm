import sys

h, w, n, m = map(int, sys.stdin.readline().split())

maxW = w // (m + 1)
if w % (m + 1) > 0:
    maxW += 1

maxH = h // (n + 1)
if h % (n + 1) > 0:
    maxH += 1

print(maxW * maxH)