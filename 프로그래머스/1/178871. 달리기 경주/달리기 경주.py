def solution(players, callings):
    running={} 
    
    for idx, player in enumerate(players):
        running[player]=idx
    
    for c in callings:
        prev=running[c]
        running[c]=prev-1
        running[players[prev-1]]=prev
        players[prev]=players[prev-1]
        players[prev-1]=c
    return players