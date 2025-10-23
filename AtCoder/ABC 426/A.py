a, b = input().split()

d = {'Ocelot': 1, 'Serval': 2, 'Lynx':3}
a = d[a]
b = d[b]

print('Yes' if a>=b else 'No')