def solution(friends, gifts):
    answer = 0
    next_month={}
    # 선물지수용
    give={} 
    take={}
    board={}
    
    for f1 in friends:
        give[f1]=0
        take[f1]=0
        next_month[f1]=0
        board[f1]={}
        for f2 in friends:
            board[f1][f2]=0;
            
    for g in gifts:
        l=g.split(" ")
        give[l[0]]+=1
        take[l[1]]+=1
        board[l[0]][l[1]]+=1;

    for g in friends:
        for t in board[g]:
            if board[g][t] == board[t][g]:
                if (give[g]-take[g])!=(give[t]-take[t]):
                    next_month[g if (give[g]-take[g])>(give[t]-take[t]) else t]+=1
            elif board[g][t]>0 or board[t][g]>0:
                next_month[g if board[g][t]>board[t][g] else t]+=1

    answer=list(sorted(next_month.values(),reverse=True))[0]//2
    return answer