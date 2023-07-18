package HomeWorkOopJava5;

import HomeWorkOopJava5.controllers.GroupController;
import HomeWorkOopJava5.controllers.StudentController;
import HomeWorkOopJava5.controllers.TeacherController;
import HomeWorkOopJava5.repositories.StudentRepository;
import HomeWorkOopJava5.repositories.TeacherRepository;
import HomeWorkOopJava5.services.GroupService;
import HomeWorkOopJava5.services.StudentService;
import HomeWorkOopJava5.services.TeacherService;
import HomeWorkOopJava5.view.GroupView;
import HomeWorkOopJava5.view.StudentView;
import HomeWorkOopJava5.view.TeacherView;

import java.util.Scanner;

/**
 * Возможный набор команд:
 * /get-student
 * /get-student name
 * /get-student id
 * /get-group 11А
 * /create-student Ivan_Morozov 18 11A
 * /delete-teacher Maria_Pavlova
 * /set-group-student-by-id 5 11Б
 */

public class UniversityApp {

    private static TeacherRepository teacherRepository;
    private static StudentRepository studentRepository;
    private static TeacherService teacherService;
    private static StudentService studentService;
    private static TeacherController teacherController;
    private static StudentController studentController;


    public static void main(String[] args) {

    //чтобы пользователь получал по api какие-то данные:
    StudentView studentView = getStudentView(); // Создаем studentView (приложение) через присвоение
    // методу getStudentController() (Alt + Enter - create metod),
    // который реализован ниже (ч-з цепочку присвовений от репы до вложения контроллера в new StudentView)
    TeacherView teacherView = getTeacherView();
    GroupView groupView = getGroupView();


//      POST
//      http://search.user/api/users/   и через точку .create() будет создавать user-a
//      http://search.user/api/users/?type-age  - например, сортировка по возрасту
        studentView.create("Ivan Morozov", 15, "05", "10А"); // Создали пользователей
        studentView.create("Petr Vorobev", 15, "255", "10А");
        studentView.create("Vlad Hamunkov", 16, "255", "11Б");
        studentView.create("Sidor Sidorov", 16, "230", "11А");
        studentView.create("Elena Praud", 14, "782", "10Б");
        studentView.create("Alla Ivanova", 16, "412", "11А");
        studentView.create("Yulia Zuper", 15, "782", "10Б");
        studentView.create("Anna Morozova", 16, "11", "11Б");

        teacherView.create("Ignat Petrovich", 24, "56481", "11Б");
        teacherView.create("Aliaksandr Kuzmich", 55, "22-14", "11А");
        teacherView.create("Konstantin Shmyil", 29, "4875", "10А");
        teacherView.create("Vladimir Shishkin", 34, "8657", "10Б");


//        studentView.sendOnConsole();  // Впихнули список на печать (sout реализован в классе studentView)               () -  по умолчанию
//        studentView.sendOnConsole(SortType.NAME);  // Впихнули список на печать (sout реализован в классе studentView) NAME -  по имени
//        studentView.sendOnConsole(SortType.ID);  // Впихнули список на печать (sout реализован в классе studentView) ID  - по ID

        studentView.removeUser("Ivan Morozov");               // Удалили одного
//        studentView.sendOnConsole();               // Опять посмотрели на список





//        groupView.printAllFromGroup("10А");
//        groupView.printAllFromGroup("10Б");
//        groupView.printAllFromGroup("11А");
//        groupView.printAllFromGroup("11Б");
//        teacherView.sendOnConsole();
        Scanner scanner = new Scanner(System.in) ;
        String useString;
        System.out.println("LIST OF COMMANDS: >>>>>>>> THE RESULT OF THE APPLICATION:\n"+
                "/get-student  >>>>>>>>  вывод на экран всех обучающихся \n" +
                "/get-student name  >>>>>>>>  вывод на экран обучающегося по имени\n" +
                "/get-student id  >>>>>>>>  вывод на экран обучающегося по ID\n" +
                "/set-group-student-by-id 5 11Б   >>>>>>>>  установить группу студента по идентификатору\n" + //------
                "/create-student name 18 +375624 11A   >>>>>>>>  создать обучающегося с именем, возрастом, телефоном и группой\n" + //------
                "/get-group 11А  >>>>>>>>  вывод на экран искомой группы\n" +
                "/delete-teacher name  >>>>>>>>  удаление педагога по имени\n" +
                "exit  >>>>>>>>  выход из программы"
        );
        while(true){
            System.out.println("INPUT, please:");
            useString = scanner.nextLine().trim().toString(); // чтение данных в переменную
            switch (useString){
                case "/get-student":
                    studentView.sendOnConsole();
                    break;
                case "/get-student id":
                    System.out.println("Enter ID, please: ");
                    Long searchID;
                    if (scanner.hasNextInt()) {
                        searchID = Long.parseLong(scanner.nextLine().trim().toString());
                        if (studentService.getUseById(searchID).size() == 0) {
                            System.out.println("Обучающегося с таким ID нет!");
                        } else {
                            System.out.println(studentService.getUseById(searchID).toString().replaceAll("^\\[|\\]$", ""));
                        }
                    } else {
                        System.out.println("Your data is not valid! ");
                    }
                    break;
                case "/get-student name":
                    System.out.println("Enter name, please: ");
                    useString = scanner.nextLine().trim().toString().replaceAll("_"," ");
                    if (studentService.getUseByName(useString).size() == 0) {
                        System.out.println("Обучающегося с таким именем нет!");
                    } else {
                        System.out.println(studentService.getUseByName(useString));
                    }
                    break;
                case "/get-group":
                    System.out.println("Enter group, please: ");
                    useString = scanner.nextLine().trim().toString();
                    groupView.printAllFromGroup(useString);
                    break;
                case "/create-student":
                    System.out.println("Введите данные по образцу: Petr_Suev 24 +35625 11A ");
                    useString = scanner.nextLine().toString();
                    String [] dataCreate = useString.split("\\s+");
                    ////////////////////////////////////////////////////////////////
                    if (dataCreate.length !=4) {
                        System.out.println("Введены неверные данные! " + dataCreate.length);
                        break;
                    } else {
                        try {
                            String name = dataCreate[0].replaceAll("_", " ");
                            Integer age = Integer.valueOf(dataCreate[1]);
                            String phoneNumber = dataCreate[2];
                            String groupTitle = dataCreate[3];
                            studentView.create(name, age, phoneNumber, groupTitle);
                        } catch (Exception e) {
                            System.out.println("Неверный формат возраста ");
                            break;
                        }
                    }
                    break;
                case "/delete-teacher":
                    System.out.println("Enter name teacher, please: ");
                    useString = scanner.nextLine().trim().toString().replaceAll("_"," ");
                    teacherService.remove(useString);
                    break;
                case "/set-group-student-by-id":
                    System.out.println("Enter ID and group please: ");
                    useString = scanner.nextLine().trim().toString().replaceAll("_"," ");
                    Long searchIdChange = 1L;
                    String group = "10A";
                    if (scanner.hasNextInt()) {
                        searchIdChange = Long.parseLong(scanner.nextLine().trim().toString());
                        if (studentService.getUseById(searchIdChange).size() == 0) {
                            System.out.println("Группы с таким ID нет!");
                        } else {
                            groupView.setGroupUseById(searchIdChange, group);
                        }
                    } else {
                        System.out.println("Your data is not valid! ");
                    }
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command entered, please repeat: \n");
                    break;
            };


        }













}
    private static TeacherView getTeacherView() {
        teacherRepository = new TeacherRepository();
        teacherService = new TeacherService(teacherRepository);
        teacherController = new TeacherController(teacherService);
        return new TeacherView(teacherController);
    }
    private static StudentView getStudentView() {  // В методе StudentView() создаем контроллер, который кладем в returne в создаваемую переменную StudentView (чтобы не создавать еще одну переменную)
        studentRepository = new StudentRepository();  // создали новый репозиторий, причем repository выносим в поле (ctrl+Alt+f) + ENTER, чтобы при создании нескольких репоз был один и тот же класс (singleton)
        // создали новый сервер, в конструктор которого положили репозиторий (см.выше)
        studentService = new StudentService(studentRepository);
        studentController = new StudentController(studentService); // создали новый контроллер, в конструктор которого положили сервис (см.выше)
        return new StudentView(studentController); //
    }
    private static GroupView getGroupView() {  // создаем groupView
        GroupService groupService = new GroupService(studentService,teacherService); //(ctrl+Shift+/) комментарий
        GroupController groupController = new GroupController(groupService);
        return new GroupView(groupController);
    }

}
