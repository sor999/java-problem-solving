/*
범위 내 시간 갯수 구하기

t에는 계속 큰값만 들어옴(시간)
큐에 넣고 범위를 벗어나는 것들은 빼주기. 이떄 q가 empty가 되진 않는지도 고려 필요

O(n)
*/
class RecentCounter {
    private Queue<Integer> requests = new LinkedList<>();

    public RecentCounter() {
        requests = new LinkedList<>();
    }

    public int ping(int t) {
        requests.offer(t);
        int range = t - 3000;
        while(!requests.isEmpty() && requests.peek() < range) requests.poll();
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */