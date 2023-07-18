package HomeWorkOopJava5.view;

import HomeWorkOopJava5.models.User;

public interface UserView <T extends User> {
    void sendOnConsole();                                       // метод "оправить сообщение" (GET) без аргументов
    void sendOnConsole(SortType sortType);                     // метод "оправить сообщение" (GET)
    void create (String fullName, Integer age, String phoneNumber, String groupTitle); // как и в контроллере         (POST)
    int removeUser (String fullName);                              //                              (DELETE)
}
