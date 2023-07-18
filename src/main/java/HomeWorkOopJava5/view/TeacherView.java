package HomeWorkOopJava5.view;

import HomeWorkOopJava5.controllers.UserController;
import HomeWorkOopJava5.models.Teacher;

import java.util.List;

public class TeacherView implements UserView<Teacher>{
    private final UserController<Teacher> teacherUserController;           // private final - меняться не будет, наводим на controller alt+Enter -
    public TeacherView(UserController<Teacher> controller) {     // - тем самым примем его извне
        this.teacherUserController = controller;
    }


    public void sendOnConsole() { //если ничего не принимаем
        sendOnConsole(SortType.NONE); //вызываем способ сортировки NONE
    }


    @Override
    public void sendOnConsole(SortType sortType) { //получаем всех студентов при помощи view, поэтому создаем его здесь (см. выше)
        //при помощи слова, переданного в аргументы будем производить сортировку по конкретному полю
//        List<Student> students = controller.getAll(); //Вкладываем наших пользователей в список (для последующего красивого отображения)
        List<Teacher> teachers = switch (sortType) {//кейс для конкретной сортировки
            case NONE -> teacherUserController.getAll(); //мы должны положить результат и новый switch их принимает в List см. выше
            case NAME -> teacherUserController.getAllSortByFullName();
            case ID -> teacherUserController.getAllSortById();
        };
        if (teachers == null || teachers.size() == 0) {
            System.out.println("Отсутствуют педагоги для вывода");
            return;
        }
        System.out.println("=================================");
        System.out.println("Для вывода использована " + sortType);
        teachers.forEach(System.out::println);

        System.out.println("=================================");
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherUserController.create(fullName, age, phoneNumber, groupTitle);

    }

    @Override
    public int removeUser(String fullName) {
        int removeCount = teacherUserController.remove(fullName);
        if (removeCount == 0) {
            System.out.println("Удаление не получилось!");
        } else {
            System.out.printf("Удаление произошло %s раз!", removeCount);
        }
        return removeCount;
    }
}
