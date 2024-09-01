import sys
def solution(wallpaper):
    answer = []
    lux,luy=sys.maxsize,sys.maxsize
    rdx,rdy=-sys.maxsize,-sys.maxsize
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j]=='#':
                if i<=lux:
                    lux=i
                if j<=luy:
                    luy=j
                if i>=rdx:
                    rdx=i
                if j>=rdy:
                    rdy=j

    return [lux,luy,rdx+1,rdy+1]