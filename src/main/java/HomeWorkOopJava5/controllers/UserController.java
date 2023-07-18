package HomeWorkOopJava5.controllers;

import HomeWorkOopJava5.models.User;

import java.util.List;

/**
 * Универсальный интерфейс для всех сущностей
 * которые наследуются от него
 * <T extends User> любой наследник класса User!
 */
public interface UserController <T extends User> {
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
}
