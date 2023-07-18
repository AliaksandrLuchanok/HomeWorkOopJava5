package HomeWorkOopJava5.repositories;

import HomeWorkOopJava5.models.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TeacherRepository implements UserRepository<Teacher>{
    private final List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ArrayList<>();
    }

    @Override
    public void create(Teacher teacher) {
        teacher.setId(getMaxId() + 1);
        teachers.add(teacher);
    }

    @Override
    public List<Teacher> getAll() {
        return teachers;
    }
    @Override
    public int remove(String fullName) {
        int countRemove = 0;

        Iterator<Teacher> iterator = teachers.iterator();
        while(iterator.hasNext()){
            Teacher teacher = iterator.next();
            if(teacher.getFullName().equals(fullName)){
                iterator.remove();
                countRemove++;
            }
        }
        return countRemove;
    }
    @Override
    public List<Teacher> getUserByName(String name) {
        return teachers.stream().filter(student -> student.getFullName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getUserById(Long id) {
        return teachers.stream().filter(teacher -> teacher.getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<Teacher> getAllByGroupTitle(String groupTitle) {
        return teachers.stream().filter(teacher -> teacher.getGroupTitle().equals(groupTitle)).collect(Collectors.toList());
    }
    public List<Teacher> setGroupUseById(Long id, String group) {
        for (Teacher teacher : teachers) {
            if (teacher.getId().equals(id)) {
                teacher.setGroupTitle(group);
            }
        }
        return teachers;
    }
    private Long getMaxId() {
        return teachers.stream().count();
    }

}
