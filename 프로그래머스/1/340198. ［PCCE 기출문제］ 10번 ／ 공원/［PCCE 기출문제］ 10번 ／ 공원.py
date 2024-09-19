def solution(mats, park):
    answer = -1
    mats.sort()
    
    for i in range(0,len(park)):
        for j in range(0,len(park[i])):
            if park[i][j]=="-1":
                for m in mats:
                    if i+m>len(park) or j+m>len(park[i]):
                        break
                    isPicnic=True
                    for r in range(i,i+m):
                        for c in range(j,j+m):
                            if park[r][c]!="-1":
                                isPicnic=False
                                break     
                    if isPicnic==False:
                        break
                    answer=max(answer,m);
                
    return answer