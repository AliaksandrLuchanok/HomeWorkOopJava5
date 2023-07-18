package HomeWorkOopJava5.models;

public class Student extends User {
    /** Наследуем super-конструктор от абстрактного User  */
    public Student(String fullName, Integer age, String phoneNumber, String groupTitle) {
        super(fullName, age, phoneNumber, groupTitle);
    }

    /** Переопределение (return String.format) */



    @Override
    public String toString() {
        return String.format("ОБУЧАЮЩИЙСЯ:\t\t\t\t\t\t id - %s, fullName - %s, age" +
                        " - %s, phoneNumber - %s, groupTitle - %s", getId(),
                getFullName(), getAge(), getPhoneNumber(), getGroupTitle());
    }

}
