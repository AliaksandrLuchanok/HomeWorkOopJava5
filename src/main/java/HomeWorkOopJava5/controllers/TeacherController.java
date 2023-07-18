package HomeWorkOopJava5.controllers;

import HomeWorkOopJava5.models.Teacher;
import HomeWorkOopJava5.services.UserService;

import java.util.List;

public class TeacherController implements UserController<Teacher>{
    private final UserService<Teacher> teacherUserService;

    public TeacherController(UserService<Teacher> teacherUserService) {
        this.teacherUserService = teacherUserService;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherUserService.create(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public List<Teacher> getAll() { return teacherUserService.getAll(); }

    @Override
    public List<Teacher> getAllSortByFullName() { return teacherUserService.getAllSortByFullName(); }

    @Override
    public List<Teacher> getAllSortById() { return teacherUserService.getAllSortById(); }

    @Override
    public int remove(String fullName) { return teacherUserService.remove(fullName); }
}
