package ap.exercises.ex5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StringCounter {

    private static class ItemCount {
        String item;
        int count;

        ItemCount(String item) {
            this.item = item;
            this.count = 1;
        }
    }

    private List<ItemCount> counts;

    public StringCounter() {
        this.counts = new ArrayList<>();
    }

    public void add(String item) {
        for (ItemCount ic : counts) {
            if (ic.item.equals(item)) {
                ic.count++;
                return;
            }
        }

        counts.add(new ItemCount(item));
    }

    public List<String> getTop(int k) {
        counts.sort((a, b) -> Integer.compare(b.count, a.count));

        List<String> result = new ArrayList<>();
        for (int i = 0; i < Math.min(k, counts.size()); i++) {
            result.add(counts.get(i).item + " : " + counts.get(i).count);
        }
        return result;
    }
}
