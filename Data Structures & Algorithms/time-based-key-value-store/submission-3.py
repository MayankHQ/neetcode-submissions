class TimeMap:

    def __init__(self):
        self.store = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.store:
            self.store[key] = []
        self.store[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.store.get(key, [])

        #binary search
        s, e = 0, len(values) - 1

        while s <= e:
            mid = (s+e)//2
            if values[mid][1] <= timestamp:
                res = values[mid][0]
                s = mid + 1
            else:
                e = mid - 1
        return res