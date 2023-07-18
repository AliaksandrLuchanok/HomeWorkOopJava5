package HomeWorkOopJava5.models;

public class Teacher extends User{
    public Teacher(String fullName, Integer age, String phoneNumber, String groupTitle) {
        super(fullName, age, phoneNumber, groupTitle);
    }

    @Override
    public String toString() {
        return String.format("ПЕДАГОГ:\t\t\t\t\t\t\t id - %s, fullName - %s, age" +
                        " - %s, phoneNumber - %s, groupTitle - %s\n",
                getId(),
                getFullName(), getAge(),getPhoneNumber(), getGroupTitle());
    }

}
