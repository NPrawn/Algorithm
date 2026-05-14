def solution(players, callings):
    dt = {}
    
    for i, player in enumerate(players):
        dt[player] = i
        
    for name in callings:
        idx = dt[name]
        prev = players[idx-1]
        players[idx], players[idx-1] = players[idx-1], players[idx]
        dt[name] = idx-1
        dt[prev] = idx
    
    return players