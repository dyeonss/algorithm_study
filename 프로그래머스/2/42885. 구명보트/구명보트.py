def solution(people, limit):
    answer = 0
    start,end=0,len(people)-1
    people.sort()
    
    while end>=start:
        if start!=end and people[start]+people[end]<=limit:
            start+=1
        answer+=1
        end-=1
            
    return answer