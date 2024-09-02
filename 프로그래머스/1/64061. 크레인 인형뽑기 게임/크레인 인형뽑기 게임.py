def solution(board, moves):
    answer = 0
    basket=[]
    loc=[len(board)]*len(board)
    
    for c in range(len(board)):
        for r in range(len(board)):
            if board[r][c]!=0:
                loc[c]=r
                break
        
    for move in moves:
        if loc[move-1]>=len(board):
            continue
        elif board[loc[move-1]][move-1]!=0:
            if len(basket)>0 and basket[-1]==board[loc[move-1]][move-1]:
                basket.pop()
                answer+=2
            else:
                basket.append(board[loc[move-1]][move-1])
            loc[move-1]+=1
    
    return answer