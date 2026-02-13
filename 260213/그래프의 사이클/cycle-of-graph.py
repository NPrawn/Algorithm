n, m = map(int, input().split())
p = [i for i in range(n+1)]
def find(x):
    while p[x] != x:
        p[x] = p[p[x]]
        x = p[x]
    return x

def union(a, b):
    a = find(a)
    b = find(b)
    
    if a==b: return False
    
    if a > b:
        p[a] = b
    else:
        p[b] = a
    return True

for ans in range(1, m+1):
    a, b = map(int, input().split())
    if (not union(a, b)): 
        print(ans)
        break
else:
    print('happy')