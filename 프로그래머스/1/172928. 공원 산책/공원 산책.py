def solution(park, routes):
    nr,nc=0,0
    dr=[0,0,1,-1]
    dc=[1,-1,0,0]
    way={'E':0,'W':1,'S':2,'N':3}
    
    for i in range(len(park)):
        idx=park[i].find('S')
        if idx!=-1:
            nr,nc=i,idx
            break

    for r in routes:
        w, dist=r.split()
        dir_=way[w]
        tr,tc=nr,nc
        success=True
        
        for i in range(1,int(dist)+1):
            tr,tc=nr+dr[dir_]*i,nc+dc[dir_]*i

            if not(0<=tr<=len(park)-1 and 0<=tc<=len(park[0])-1 and park[tr][tc]!='X'):
                success=False
                break
                
        if success:
            nr,nc=tr,tc
        
    return [nr,nc]      