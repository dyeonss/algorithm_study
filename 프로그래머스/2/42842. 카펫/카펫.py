def solution(brown, yellow):
    w,h=brown//2-1,3
    
    while True:
        if w*h-brown==yellow:
            break
        w-=1
        h+=1
        
    return [w,h]