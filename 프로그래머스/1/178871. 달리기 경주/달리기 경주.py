import copy

def solution(players, callings):
    
    playerRank = {player: i for i, player in enumerate(players)}
    

    for calling in callings:
        rank = playerRank[calling]
        playerRank[calling] -= 1
        playerRank[players[rank - 1]] += 1
        players[rank - 1], players[rank] = players[rank], players[rank -1]

    return players