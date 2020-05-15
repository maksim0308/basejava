/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i <= size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (get(r.uuid) == null) {
            storage[size()] = r;
            size++;
        } else {
            System.out.println("Резюме с uuid = " + r.uuid + " уже существует");
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
            i++;
        }

        return null;
    }

    void delete(String uuid) {
        int i = 0;
        boolean isFind = false;

        while (i < size) {
            if (storage[i].uuid.equals(uuid)) {
                isFind = true;
            }

            if (isFind) storage[i] = storage[i + 1];

            i++;
        }
        if (isFind) size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] allResume = new Resume[size];

        for (int i = 0; i < size; i++) {
            allResume[i] = storage[i];
        }

        return allResume;
    }

    int size() {
        return size;
    }
}
