# 그리디로 풀어보기
# L,R 중 큰값을 기준으로 내림차순 정렬
# 정렬된 순서대로 고르면서 L,R 고른 갯수를 카운팅
# L 혹은 R을 최대로 사용했을때 골라야한다면
# L, R 중 최대가 아닌 수로 다시 배열에 추가 후 정렬
# 정렬은 O(n*logn) / 최악의 경우라도 정렬이 n번 수행되기 때문에 가능? O(n*n*logn)

# L==R 일수가 있기 때문에 그리디 풀이 불가능
# L==R인 순서쌍에서 좌, 우를 선택할때 어떤 곳을 아껴야하는지 모름
# 이후 나오는 순서쌍 중 L이 큰지 R이 큰지 판별 불가능하기 때문이다

n = int(input())
lst = []
for _ in range(n):
	a,b = map(int, input().split())
	if a>b: c = 0
	else: c = 1
	d = max(a,b)
	lst.append([a,b,c,d])

lst.sort(key=lambda x: x[3], reverse=True)
used = [0, 0]
idx = 0
ans = 0
while used[0]<15 or used[1]<15:
	a, b, c, d = lst[idx]
	if c == 0 and used[0] == 15:
		lst.append([a,b,1,b])
		lst.sort(key=lambda x: x[3], reverse=True)
	elif c == 1 and used[1] == 15:
		lst.append([a,b,0,a])
		lst.sort(key=lambda x: x[3], reverse=True)
	else:
		ans += d
		used[c] += 1
	idx+=1
print(ans)