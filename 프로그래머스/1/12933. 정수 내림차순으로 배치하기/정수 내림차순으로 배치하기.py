def solution(n):
    answer = 0
    return int(''.join(reversed(sorted(str(n)))))