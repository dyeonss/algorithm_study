def solution(s):
    answer = ''
    nums=[int(i) for i in s.split()]
    return str(min(nums))+" "+str(max(nums))