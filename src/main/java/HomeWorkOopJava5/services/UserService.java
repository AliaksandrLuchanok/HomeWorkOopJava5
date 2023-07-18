package HomeWorkOopJava5.services;

import HomeWorkOopJava5.models.User;

import java.util.List;

/**
 * Как и в Userконтроллере вся примитивная логика
 * Сервисы добавляют нам единство, т.к. репозитории будут добавляться новые
 * и они должны работать идентично - идентичными данными
 */

public interface UserService <T extends User> {
    /** Возможность создания пользователя типа User с возвращаемым типом логического "Получилось-не получилось" */
    void create (String fullName, Integer age, String phoneNumber, String groupTitle);
    /** Возможность получить список всех пользователей типа User */
    List<T> getAll();
    /** Возможность сортировки по имени */
    List<T> getAllSortByFullName();
    /** Возможность сортировки по Id */
    List<T> getAllSortById();
    /** Возможность удалить пользователя по полю fullName */
    int remove(String fullName);

    List<T> getAllByTitle(String groupTitle);
    List<T> getUseById(Long id);
    List<T> getUseByName(String name);
    List<T> setGroupUseById(Long id, String group);

}
