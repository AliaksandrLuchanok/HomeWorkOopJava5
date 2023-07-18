package HomeWorkOopJava5.repositories;

import HomeWorkOopJava5.models.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * не в формате базы данных, а просто в формате List
 * (в resources можно создать текстовый файл, где пропишем наших студентиков)
 * оттуда parsing -> create new User (каждый запуск программы начинается с предыдущего момента)
 * В репозитории нет никакой логики, только что-то добавить, изменить, удалить, обновить
 */
public class StudentRepository implements UserRepository<Student> {
    /**
     * Список, выступающий в роли базы данных
     */
    private final List<Student> students;

    public StudentRepository() {
        this.students = new ArrayList<>();
    }

    @Override
    public void create(Student student) { // делаем создание через "принять готового студента (которого создадим в сервисе Student и не перегружать Controller)"
        student.setId(getMaxId() + 1); //присваиваем ему ID, возвращаемое методом .getId() (см. ниже)
        students.add(student);             // и закидываем сюда в список
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public int remove(String fullName) {
        int removeCount = 0;                               // переменная подподсчета удалений

        Iterator<Student> iterator = students.iterator(); // создаем итератор для класса Student (определять next и has next не нужно, т.к. мы работаем с ArrayList - встроенный функционал)
        while (iterator.hasNext()) {
            Student student = iterator.next();          // получаем студента, находящегося на следующей позиции
            if (student.getFullName().equals(fullName)) {// если имя есть в списке
                iterator.remove();                      // тогда удаляем его
                removeCount++;
            }
        }
        return removeCount;
    }

    @Override
    public List<Student> getUserById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList());
    }

    @Override
    public List<Student> getUserByName(String name) {
        return students.stream().filter(student -> student.getFullName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public List<Student> getAllByGroupTitle(String groupTitle) {
        //это фильтр по всем названиям (stream api позволяет пробежаться по всем студентам и их фильтровать по группе)
        //также можно преобразовывать в другой тип данных, сравнивать, из списка в сложные map-ы (.map), указать количество возвращаемых User-ов
        //пагинацию - не 1000, а по 10 человек (.skip)

        return students.stream().filter(student -> student.getGroupTitle().equals(groupTitle)).collect(Collectors.toList());
    }

    private Long getMaxId() { // отдельный метод проверки на размерность списка и возврата его значения, как ID
//        Long maxId = 0L;      // чтобы при создании студента, установить ему этот ID (см. выше)
//        for (Student student:students) {
//            if(student.getId()>maxId) {
//                maxId = student.getId();
//            }
//        }

        return students.stream().count();
    }

    public List<Student> setGroupUseById(Long id, String group) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setGroupTitle(group);
            }
        }
                return students;
    }
}
