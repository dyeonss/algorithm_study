def solution(wallpaper):
    answer = []
    rdx,rdy,lux,luy=-1,-1,51,51
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j]=='#':
                lux=min(i,lux)
                luy=min(j,luy)
                rdx=max(i,rdx)
                rdy=max(j,rdy)

    return [lux,luy,rdx+1,rdy+1]