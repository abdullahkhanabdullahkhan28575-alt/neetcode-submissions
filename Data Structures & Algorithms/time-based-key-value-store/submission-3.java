

class TimeMap {

    class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair> list = map.get(key);

        int l = 0;
        int r = list.size() - 1;

        String ans = "";

        while (l <= r) {

            int m = l + (r - l) / 2;

            if (list.get(m).timestamp <= timestamp) {
                ans = list.get(m).value;
                l = m + 1;
            } 
            else {
                r = m - 1;
            }
        }

        return ans;
    }
}