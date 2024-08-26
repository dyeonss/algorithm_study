def solution(today, terms, privacies):
    answer = []
    year,month,day=today.split('.')
    today=int(year)*12*28+int(month)*28+int(day)
    info={}
    
    for term in terms:
        t,p=term.split()
        info[t]=int(p)
    
    for i,privacy in enumerate(privacies):
        y,m,d=privacy[:10].split('.')
        start=int(y)*12*28+int(m)*28+int(d)
        end=start+info[privacy[-1]]*28
        if end<=today:
            answer.append(i+1)
            
    return answer