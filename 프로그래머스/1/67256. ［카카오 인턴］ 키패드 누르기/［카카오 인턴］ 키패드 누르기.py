def solution(numbers, hand):
    answer = ''
    l,r=10,12
    
    for n in numbers:
        if n==0:    n=11
        if n in [1,4,7]:
            answer+='L'
            l=n
        elif n in [3,6,9]:
            answer+='R'
            r=n
        else:
            lmv=abs((l+1 if l in [1,4,7,10] else l)-n)//3+(1 if l in[1,4,7,10] else 0)
            rmv=abs((r-1 if r in [3,6,9,12] else r)-n)//3+(1 if r in[3,6,9,12] else 0)
            # print("l:",l,"r:",r,"n:",n)
            # print("lmv:",lmv,"rmv:",rmv)
            if lmv==rmv: 
                if hand=='right':
                    answer+='R'
                    r=n
                else:
                    answer+='L'
                    l=n
            else:
                if rmv<lmv:
                    answer+='R'
                    r=n
                else:
                    answer+='L'
                    l=n

    return answer