def solution(people, limit):
    answer = 0
    start,end=0,len(people)-1
    people.sort()
    
    while end>=start:
        if people[start]+people[end]<=limit:
            answer+=1
            start,end=start+1,end-1
        else:
            answer+=1
            end-=1
            
    return answer