def solution(friends, gifts):
    friends_idx={}
    n=len(friends)
    
    for i in range(n):
        friends_idx[friends[i]]=i

    table=[[0]*n for _ in range(n)]
    gift_idx=[0]*n
    
    for gift in gifts:
        g,t=gift.split()
        g_idx=friends_idx[g]
        t_idx=friends_idx[t]
        table[g_idx][t_idx]+=1
        gift_idx[g_idx]+=1
        gift_idx[t_idx]-=1
    
    get_gifts=[0]*n
    
    for i in range(n):
        for j in range(n):
            if i==j:    continue
            if table[i][j]==table[j][i]:
                if gift_idx[i]>gift_idx[j]:
                    get_gifts[i]+=1
            elif table[i][j]>table[j][i]:
                get_gifts[i]+=1
                
    return max(get_gifts)