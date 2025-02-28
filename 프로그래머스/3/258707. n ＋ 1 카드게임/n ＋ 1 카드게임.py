# 처음의 카드 뭉치의 n/3을 가진다.
# 각 라운드마다 시작할 때 카드 두장을 뽑는다
# 뽑은 카드는 동전을 이용해 가지거나 동전을 소모하지 않고 버린다.
# 카드에 적힌 수의 합이 n + 1 이 도되록 카드 두 장을 내고 다음 라운드 진행, 낼 수 없다면 게임 종료
from collections import deque

def solution(coin, cards):
    answer = 1
    size = len(cards)
    hand = set(cards[:size // 3])
    rest = deque(cards[size // 3 :])
    possible = set()
    
    goal = len(cards) + 1
    
    while True:
        if len(rest) >= 2:
            possible.add(rest.popleft())
            possible.add(rest.popleft())
        else:
            break
        # 손에 n + 1의 카드가 있는 경우
        if have_goal(hand, goal):
            answer += 1
            continue
        
        if coin >= 1 and have_in_hand_possible(hand, possible, goal):
            coin -= 1
            answer += 1
            continue
        
        if coin >= 2 and have_goal(possible, goal):
            coin -= 2
            answer += 1
            continue
        break
    return answer 

def have_goal(hand, goal):
    for i in list(hand):
        target = goal - i
        if target in hand:
            hand.remove(target)
            hand.remove(i)
            return True
    return False

def have_in_hand_possible(hand, possible, goal):
    for i in list(hand):
        target = goal - i
        if target in possible:
            hand.remove(i)
            possible.remove(target)
            return True
    return False
    
