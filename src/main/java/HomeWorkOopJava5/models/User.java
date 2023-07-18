package HomeWorkOopJava5.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data //Getter, setter, equels hash-code to-String, rewuedArgsConstructor, т.е. по умолчанию сделает конструктор только для поля id
@AllArgsConstructor //мы сделаем конструктор для всех полей - AllArgsConstructor (входит в @Data)

public abstract class User implements Comparable<User>{ // для сортировки либо отдельный Comparator, либо сортировка самих юзеров
    /** Поле ID  */ //(сняли final (константу), чтобы создать пользователя в StudentService
    private Long id;
    /** Поле fullName - имя и фамилия */
    private String fullName; // заберем из компоратора
    /** Поле age */
    private Integer age;
    /** Поле phoneNumber */
    private String phoneNumber;
    private String groupTitle; //  создаем поле "Название группы"

    public User(String fullName, Integer age, String phoneNumber,
                String groupTitle) { // создаем конструктор с 3-мя полями, чтобы забыть ID
        this.fullName = fullName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.groupTitle = groupTitle;

    }

    @Override
    public int compareTo(User o) { // реализуем здесь, т.к. сортировки будут одинаковые как для Student, так и для Teacher
        return getAge().compareTo(o.getAge());
    }    //в сервисе добавляем логику в метод getAll


}
