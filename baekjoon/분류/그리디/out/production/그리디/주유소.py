N = int(input()) #도시의 수
load = list(map(int,input().split()))
city_gas_cost = list(map(int,input().split()))
lower_cost = city_gas_cost[0]
total_cost = 0

for i in range(N-1):
    if lower_cost > city_gas_cost[i]:
        lower_cost = city_gas_cost[i]
    total_cost += lower_cost * load[i]

print(total_cost)