def solution(elements):
    nums=set();
    size=len(elements)
    elements=elements*2
    
    for i in range(1,size+1):
        for j in range(0,len(elements)-i+1):
            nums.add(sum(elements[j:j+i]))

    return len(nums)