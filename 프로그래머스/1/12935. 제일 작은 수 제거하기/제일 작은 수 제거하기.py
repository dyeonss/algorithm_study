def solution(arr):
    arr.remove(list(sorted(arr))[0])
    return [-1] if len(arr)==0 else arr