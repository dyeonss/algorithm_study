def solution(want, number, discount):
    answer = 0
    pd={}
    for i in range(len(want)):
        pd[want[i]]=i

    for i in range(len(discount)-9):
        cnts=[0]*len(want)
        for j in range(i,i+10):
            if discount[j] in pd:
                cnts[pd[discount[j]]]+=1
        possible=True
        for j in range(len(want)):
            if number[j]>cnts[j]:
                possible=False
                break
        if possible:    answer+=1
    return answer