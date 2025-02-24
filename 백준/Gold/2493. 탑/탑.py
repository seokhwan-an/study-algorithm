class Tower:
    def __init__(self, height, index):
        self.height = height
        self.index = index

def get_receiver_top_orders(heights):
    stack = []
    answer = [0] * len(heights)
    for i in range(len(heights) - 1, -1, -1):
        h = heights[i]
        if len(stack) == 0:
            stack.append(Tower(h, i))
        else:
            while stack and h > stack[len(stack) - 1].height:
                tower = stack.pop()
                answer[tower.index] = i + 1
            stack.append(Tower(h, i))

    return answer

n = int(input())
heights = list(map(int, input().split(" ")))
answer = get_receiver_top_orders(heights)

print(" ".join(map(str, answer)))
