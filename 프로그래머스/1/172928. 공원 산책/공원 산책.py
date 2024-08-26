def solution(park, routes):
    nr,nc=0,0
    dr=[0,0,1,-1]
    dc=[1,-1,0,0]
    
    for i in range(len(park)):
        idx=park[i].find('S')
        if idx!=-1:
            nr,nc=i,idx
            break

    for r in routes:
        way, dist=r.split()
        dir=0
        if way=='E':
            dir=0
        elif way=='W':
            dir=1
        elif way=='S':
            dir=2
        else:
            dir=3
        
        tr,tc=nr,nc
        success=True
        
        for i in range(int(dist)):
            tr+=dr[dir]
            tc+=dc[dir]
            if tr<0 or tr>len(park)-1 or tc<0 or tc>len(park[0])-1:
                success=False
                break
            if park[tr][tc]=='X':
                success=False
                break
        
        if success:
            nr,nc=tr,tc
        
    return [nr,nc]      