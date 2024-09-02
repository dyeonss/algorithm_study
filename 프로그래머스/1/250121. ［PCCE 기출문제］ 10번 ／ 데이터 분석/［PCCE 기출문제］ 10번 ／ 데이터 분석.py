def solution(data, ext, val_ext, sort_by):
    answer = []
    typ={"code":0,"date":1,"maximum":2,"remain":3}
    
    for d in data:
        if(d[typ[ext]]<val_ext):
            answer.append(d)
    
    answer.sort(key=lambda x:x[typ[sort_by]])
    
    return answer