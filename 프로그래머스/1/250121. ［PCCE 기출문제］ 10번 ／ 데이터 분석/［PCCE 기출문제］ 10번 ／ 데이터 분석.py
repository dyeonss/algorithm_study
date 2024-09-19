def solution(data, ext, val_ext, sort_by):
    answer = []
    map={"code":0,"date":1,"maximum":2,"remain":3}
    
    for i in range(0,len(data)):
        if data[i][map[ext]]<val_ext:
            answer.append(data[i])
    
    answer.sort(key=lambda x:x[map[sort_by]])
    return answer