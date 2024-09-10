def solution(brown, yellow):
    x,y=(brown-4)//2-1,1
    
    while True:
        if x*y==yellow:
            break
        x,y=x-1,y+1
        
    return [x+2,y+2]