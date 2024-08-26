def solution(today, terms, privacies):
    answer = []
    year,month,day=today.split('.')
    today=int(year)*12*28+int(month)*28+int(day)
    info={}
    
    info={t[0]: int(t[2:]) for t in terms}
    
    for i,privacy in enumerate(privacies):
        y,m,d=privacy[:10].split('.')
        start=int(y)*12*28+int(m)*28+int(d)
        end=start+info[privacy[-1]]*28
        if end<=today:
            answer.append(i+1)
            
    return answer