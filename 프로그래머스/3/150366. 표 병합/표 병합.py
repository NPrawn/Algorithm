def solution(commands):
    SIZE = 51
    EMPTY = "EMPTY"
    MAX = SIZE * SIZE

    def get_id(r, c):
        return r * SIZE + c

    root = [0] * MAX
    head = [0] * MAX
    tail = [0] * MAX
    nxt = [-1] * MAX
    value = [EMPTY] * MAX

    for r in range(1, 51):
        for c in range(1, 51):
            idx = get_id(r, c)
            root[idx] = idx
            head[idx] = idx
            tail[idx] = idx
            nxt[idx] = -1
            value[idx] = EMPTY

    answer = []

    def update_cell(r, c, v):
        idx = get_id(r, c)
        rt = root[idx]
        value[rt] = v

    def update_value(v1, v2):
        for r in range(1, 51):
            for c in range(1, 51):
                idx = get_id(r, c)

                if root[idx] == idx and value[idx] == v1:
                    value[idx] = v2

    def merge(r1, c1, r2, c2):
        id1 = get_id(r1, c1)
        id2 = get_id(r2, c2)

        rt1 = root[id1]
        rt2 = root[id2]

        # 이미 같은 그룹이면 무시
        if rt1 == rt2:
            return

        v1 = value[rt1]
        v2 = value[rt2]

        if v1 != EMPTY:
            merged_value = v1
        else:
            merged_value = v2

        cur = head[rt2]
        while cur != -1:
            root[cur] = rt1
            cur = nxt[cur]

        nxt[tail[rt1]] = head[rt2]
        tail[rt1] = tail[rt2]

        value[rt1] = merged_value
        value[rt2] = EMPTY

    def unmerge(r, c):
        idx = get_id(r, c)
        rt = root[idx]

        saved_value = value[rt]
        
        cells = []
        cur = head[rt]

        while cur != -1:
            cells.append(cur)
            cur = nxt[cur]

        for cell in cells:
            root[cell] = cell
            head[cell] = cell
            tail[cell] = cell
            nxt[cell] = -1
            value[cell] = EMPTY

        value[idx] = saved_value

    def print_cell(r, c):
        idx = get_id(r, c)
        rt = root[idx]
        answer.append(value[rt])

    for command in commands:
        cmd = command.split()

        if cmd[0] == "UPDATE":
            if len(cmd) == 4:
                r = int(cmd[1])
                c = int(cmd[2])
                v = cmd[3]
                update_cell(r, c, v)
            else:
                v1 = cmd[1]
                v2 = cmd[2]
                update_value(v1, v2)

        elif cmd[0] == "MERGE":
            r1 = int(cmd[1])
            c1 = int(cmd[2])
            r2 = int(cmd[3])
            c2 = int(cmd[4])
            merge(r1, c1, r2, c2)

        elif cmd[0] == "UNMERGE":
            r = int(cmd[1])
            c = int(cmd[2])
            unmerge(r, c)

        elif cmd[0] == "PRINT":
            r = int(cmd[1])
            c = int(cmd[2])
            print_cell(r, c)

    return answer