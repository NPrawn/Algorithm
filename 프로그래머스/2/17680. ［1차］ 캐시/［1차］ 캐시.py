def solution(cacheSize, cities):
    answer = 0
    cache = []
    if cacheSize == 0:
        return len(cities) * 5
    for city in cities:
        city = city.lower()
        if city in cache:
            answer+=1
            cache.remove(city)
            cache.append(city)
        elif len(cache) == cacheSize:
            cache.remove(cache[0])
            cache.append(city)
            answer+=5
        else:
            cache.append(city)
            answer+=5
    
    return answer