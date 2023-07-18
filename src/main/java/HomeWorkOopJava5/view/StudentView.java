package HomeWorkOopJava5.view;

import HomeWorkOopJava5.controllers.UserController;
import HomeWorkOopJava5.models.Student;

import java.util.List;

/**
 * Задача view - красивое отображение
 */
public class StudentView implements UserView{
    private final UserController<Student> controller;           // private final - меняться не будет, наводим на controller alt+Enter -
    public StudentView(UserController<Student> controller) {     // - тем самым примем его извне
        this.controller = controller;
    }


    public void sendOnConsole() { //если ничего не принимаем
        sendOnConsole(SortType.NONE); //вызываем способ сортировки NONE
    }


    @Override
    public void sendOnConsole(SortType sortType) { //получаем всех студентов при помощи view, поэтому создаем его здесь (см. выше)
                                  //при помощи слова, переданного в аргументы будем производить сортировку по конкретному полю
//        List<Student> students = controller.getAll(); //Вкладываем наших пользователей в список (для последующего красивого отображения)
        List<Student> students = switch (sortType) {//кейс для конкретной сортировки
            case NONE -> controller.getAll(); //мы должны положить результат и новый switch их принимает в List см. выше
            case NAME -> controller.getAllSortByFullName();
            case ID -> controller.getAllSortById();
        };
        if (students == null || students.size() == 0) {   //Немного валидации - если null - списка нет, или количество элементов в нем == 0
            System.out.println("Отсутствуют студенты для вывода"); // Инфа пользователю
            return;
        }
            System.out.println("=================================");
            System.out.println("Для вывода использована " + sortType);
//            students.forEach(student->System.out.println(student));   // форма вывода
            students.forEach(System.out::println);   // иначе выводим красивый список сокращенной формой

            System.out.println("=================================");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        controller.create(fullName, age, phoneNumber, groupTitle); //редиректим все вовнутрь

    }

    @Override
    public int removeUser(String fullName) {
        int removeCount = controller.remove(fullName);
        if (removeCount == 0) {
            System.out.println("Удаление не получилось!");
        } else {
            System.out.printf("Удаление произошло %s раз!", removeCount);
        }
        return removeCount;
    }
}
