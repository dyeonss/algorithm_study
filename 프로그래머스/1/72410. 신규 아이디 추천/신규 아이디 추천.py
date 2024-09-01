def solution(new_id):
    answer = ''
    
    new_id=new_id.lower()
    for w in new_id:
        if w.isalnum() or w in '-_.':
            answer+=w
            
    while '..' in answer:
        answer=answer.replace('..','.')

    if len(answer)>0 and answer[0]=='.':
        answer=answer[1:]
    if len(answer)>0 and answer[-1]=='.':
        answer=answer[:-1]
    
    if len(answer)==0:
        answer='a'
    if len(answer)>=16:
        answer=answer[:15]
        if answer[-1]=='.':
            answer=answer[:-1]
    
    while len(answer)<3:
        answer+=answer[-1]

    return answer