package HomeWorkOopJava5.repositories;

import HomeWorkOopJava5.models.User;

import java.util.List;

/**
 * Что, где и как будет храниться
 */
public interface UserRepository<T extends User> {
    /** Возможность создания пользователя типа User с возвращаемым типом логического "Получилось-не получилось" */
    void create (T user);
    /** Возможность получить список всех пользователей типа User */
    List<T> getAll();
    /**
     * Возможность удалить пользователя по полю fullName
     */
    int remove(String fullName);

    List<T> getAllByGroupTitle(String groupTitle);

    List<T> getUserById(Long id);


    List<T> getUserByName(String name);
    List<T> setGroupUseById(Long id, String group);

}
