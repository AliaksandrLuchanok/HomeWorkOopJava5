package HomeWorkOopJava5.services;

import HomeWorkOopJava5.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupService { //не будем обращаться к отдельному репозиторию, просто к сервису студентов
    private final static List countsId = new ArrayList<>();
    private Long id;

    private final List<User> groups;

    private final StudentService studentService;
    private final TeacherService teacherService;


    public GroupService(StudentService studentService, TeacherService teacherService) {
        if (this.id == null) {
            this.id = getIdGroup();
        }
        groups = new ArrayList<>();
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    public List<User> getAllUsersFromGroup(String groupTitle) { //повторим то, что есть в GroupController
        List<User> userList = new ArrayList<>();
        var teachers = teacherService.getAllByTitle(groupTitle);
        var students = studentService.getAllByTitle(groupTitle);
        userList.addAll(teachers);
        userList.addAll(students);
        return userList;
    }
    public List<User> setGroupUseById(Long id, String group) { //повторим то, что есть в GroupController
        var teachers = teacherService.setGroupUseById(id, group);
        var students = studentService.setGroupUseById(id, group);
        groups.addAll(teachers);
        groups.addAll(students);
        return groups;
    }
    public Long getIdGroup(){
        Random random = new Random();
        long id = random.nextLong(100);
        if (countsId.contains(id)){
            id = getIdGroup();
        } else {
            countsId.add(id);
        }
        return id;
    }

}
