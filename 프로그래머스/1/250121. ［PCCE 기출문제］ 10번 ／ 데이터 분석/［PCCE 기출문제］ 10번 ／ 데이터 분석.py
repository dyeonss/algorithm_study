def solution(data, ext, val_ext, sort_by):
    answer = []
    typ={}
    
    typ["code"]=0
    typ["date"]=1
    typ["maximum"]=2
    typ["remain"]=3
    
    for d in data:
        if(d[typ[ext]]<val_ext):
            answer.append(d)
    
    answer.sort(key=lambda x:x[typ[sort_by]])
    
    return answer