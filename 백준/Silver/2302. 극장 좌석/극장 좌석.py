def get_all_ways_of_theater_seat(total_count, fixed_seat_array):
    dp = [0] * (total_count + 1)
    if total_count == 1:
        return 1
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2


    for i in range(3, total_count + 1):
        dp[i] = dp[i - 1] + dp [i - 2]

    answer = 1
    current_index = 0
    for index in fixed_seat_array:
        answer *= dp[index - 1 - current_index]
        current_index = index

    if current_index != total_count:
        answer *= dp[total_count - current_index]


    return answer



N = int(input())
M = int(input())
static_seat = []
for _ in range(M):
    static_seat.append(int(input()))

print(get_all_ways_of_theater_seat(N, static_seat))
