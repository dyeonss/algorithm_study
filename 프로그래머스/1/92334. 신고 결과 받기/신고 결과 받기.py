def solution(id_list, report, k):
    n=len(id_list)
    answer = [0]*n
    id_index={}
    complain_count=[0]*n
    complain_list={}
        
    for idx,id in enumerate(id_list):
        id_index[id]=idx
        complain_list[id]=[]
    
    for r in set(report):
        a,b=r.split()
        complain_list[a].append(b)
        complain_count[id_index[b]]+=1

    for idx,cnt in enumerate(complain_count):
        if cnt>=int(k):
            for key,val in complain_list.items():
                if id_list[idx] in val:
                    answer[id_index[key]]+=1
    return answer