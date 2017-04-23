package for_testing.mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ImitationDB {
    private List<String> data;

    public ImitationDB() {
        this.data = new ArrayList<>();
        data.addAll(Arrays.asList("Object1", "Object2", "Object3"));
    }

    public List<String> getAllRecords() {
        return data;
    }

    public void insertData(String object) {
        data.add(object);
    }

    public void delete(int index) {
        data.remove(index);
    }
}
