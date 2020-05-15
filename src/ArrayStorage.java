/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i =  0; i <= size(); i++)
        {
            storage[i] = null;
        }
        System.out.println(size());
    }

    void save(Resume r) {
        if (get(r.uuid) == null) {
            storage[size()] = r;
        }
        else {System.out.println("Резюме с uuid = "+r.uuid + " уже существует");}
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null)
        {
            if (storage[i].uuid.equals(uuid)) return storage[i];
            i++;
        }

        return null;
    }

    void delete(String uuid) {
        int size = size();
        int i = 0;
        boolean isFind = false;

        while (i < size) {
            if (storage[i].uuid.equals(uuid)) isFind = true;

            if (isFind) storage[i] = storage[i+1];

            i++;
        }
    }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size()];

        for (int i=  0; i < size(); i++) {
            allResume[i] = storage[i];
        }

        return allResume;//=new Resume[0];
    }

    int size() {
        int cnt = 0;
        int i = 0;

        while (storage[i] != null) {
            cnt++;
            i++;
        }
        i = 0;
        return cnt;
    }
}
