def solution(bandage, health, attacks):
    now_health=health
    success=0
    index=0
    
    for i in range(1, attacks[-1][0]+1):
        if now_health<=0:
            break
        if i==attacks[index][0]:
            success=0
            now_health-=attacks[index][1]
            index+=1
        else:
            success+=1
            if success==bandage[0]:
                now_health=min(now_health+bandage[1]+bandage[2],health)
                success=0
            else:
                now_health=min(now_health+bandage[1],health)
                
    return -1 if now_health<=0 else now_health