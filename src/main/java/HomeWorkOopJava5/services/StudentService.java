package HomeWorkOopJava5.services;

import HomeWorkOopJava5.models.Student;
import HomeWorkOopJava5.models.User;
import HomeWorkOopJava5.repositories.UserRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Ловит запрос от контроллера обрабатывает логику (создает, проверяет и т.д.) всего того, что есть в репе */
public class StudentService implements UserService<Student>{
    /** Создаем репозиторий */
    private final UserRepository<Student> studentRepository;

    public StudentService(UserRepository<Student> userRepository) {
        this.studentRepository = userRepository;
    }

    @Override
    public void create(String fullName, Integer age, String phoneNumber, String groupTitle) { // у нас нет ID, но в хорошей BD он подставится автоматически, поэтому в User  снимем отметку final
        studentRepository.create(new Student(fullName, age, phoneNumber, groupTitle)); // но тогда контроллер не подойдет, поскольку нужно туда передавать final-ID
    }

    @Override
    public List<Student> getAll() {
        var students = studentRepository.getAll(); //  положили всех студентиков из репы в переменную var
        Collections.sort(students);             // сортируем студентиков
        return  students;
    }

    public List<Student> getAllSortByFullName() { //  сделаем сортировку по имени, а ,т.к. метода нет в UseService, то добавим его туда
        var students = studentRepository.getAll(); // можно сделать сортировку 1. сделать Comparator в отдельном файле
//        students.sort((o1, o2) -> o1.getFullName().compareTo(o2.getFullName()));   // 2. реализовать внутри при помощи анонимного класса
        students.sort(Comparator.comparing(User::getFullName));

        return students;
    }
    public List<Student> getAllSortById() { //  сделаем сортировку по ID
        var students = studentRepository.getAll();
        students.sort(Comparator.comparing(User::getId));

        return students;
    }

    @Override
    public int remove(String fullName) {
        return studentRepository.remove(fullName);
    }

    @Override
    public List<Student> getAllByTitle(String groupTitle) {//обращаемся к репозиторию, т.к. это операция базы данных
        return studentRepository.getAllByGroupTitle(groupTitle);
    }

    @Override
    public List<Student> getUseById(Long id) {
        return studentRepository.getUserById(id);
    }

    @Override
    public List<Student> getUseByName(String name) {
        return studentRepository.getUserByName(name);
    }
    public List<Student> setGroupUseById(Long id, String group) {
        return studentRepository.setGroupUseById(id,group);
    }

}
