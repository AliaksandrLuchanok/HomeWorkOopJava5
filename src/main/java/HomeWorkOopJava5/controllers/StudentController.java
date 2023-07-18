package HomeWorkOopJava5.controllers;

import HomeWorkOopJava5.models.Student;
import HomeWorkOopJava5.services.UserService;

import java.util.List;

/**
 * StudentController, имплементирует интерфейс
 * UserController<Student> (<только со студентами!>)
 */
public class StudentController implements UserController<Student>{
    /** Создаем переменную userService */
    private final UserService<Student> userService;

    /** Через alt-insert spring автоматом положит в конструктор userService */
    public StudentController(UserService<Student> userService) {
        this.userService = userService;
    }



    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) { // по хорошему здесь конвертирует данные из json в полноценные данные
        userService.create(fullName,age,phoneNumber, groupTitle);  // через переменную userService обращаемся к полю .create(fullName,age,phoneNumber) в этом классе
    }

    @Override
    public List<Student> getAll() { // по хорошему здесь заворачивает данные в json + дает статус (200)
        return userService.getAll(); // через переменную userService обращаемся к полю .getAll() в этом классе
    }

    @Override
    public List<Student> getAllSortByFullName() {
        return userService.getAllSortByFullName();
    }

    @Override
    public List<Student> getAllSortById() {
        return userService.getAllSortById();
    }

    @Override
    public int remove(String fullName) {
        return userService.remove(fullName); // через переменную userService обращаемся к полю .remove(fullName) в этом классе
    }


}
