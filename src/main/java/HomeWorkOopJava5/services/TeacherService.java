package HomeWorkOopJava5.services;

import HomeWorkOopJava5.models.Teacher;
import HomeWorkOopJava5.models.User;
import HomeWorkOopJava5.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherService implements UserService<Teacher> {
    private final UserRepository<Teacher> teacherRepository;

    public TeacherService(UserRepository<Teacher> teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) {
        teacherRepository.create(new Teacher(fullName, age, phoneNumber, groupTitle));
    }

    @Override
    public List<Teacher> getAll() {
        var teachers = teacherRepository.getAll();
        Collections.sort(teachers);
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortByFullName() {
        var teachers = teacherRepository.getAll();
        teachers.sort(Comparator.comparing(User::getFullName));
        return teachers;
    }

    @Override
    public List<Teacher> getAllSortById() {
        var teachers = teacherRepository.getAll();
        teachers.sort(Comparator.comparing(User::getId));
        return teachers;
    }

    @Override
    public int remove(String fullName) {
        return teacherRepository.remove(fullName);
    }

    @Override
    public List<Teacher> getAllByTitle(String groupTitle) {
        return teacherRepository.getAllByGroupTitle(groupTitle);
    }
    @Override
    public List<Teacher> getUseById(Long id) {
        return teacherRepository.getUserById(id);
    }

    @Override
    public List<Teacher> getUseByName(String name) {
        return teacherRepository.getUserByName(name);
    }

    @Override
    public List<Teacher> setGroupUseById(Long id, String group) {
        return teacherRepository.setGroupUseById(id, group);
    }
}
