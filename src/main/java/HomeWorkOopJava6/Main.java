package HomeWorkOopJava6;


import HomeWorkOopJava6.work3.Formality;
import HomeWorkOopJava6.work3.Greeter;

public class Main {
    public static void main(String[] args) {
        System.out.println("WORK 1:");
        System.out.println("interface Figure:\n" + "class Rectangle implements Figure:\n" +
                            "\t\t\t\t\t\t\t\tint height;\n" + "\t\t\t\t\t\t\t\tint width;\n" +
                            "class Square implements Figure:\n" + "\t\t\t\t\t\t\t\tint sideSquere;");
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("WORK 2:");
        System.out.println("interface ReportGenerator:  \t\t\tString generateFormat()\n" +
                "\tinterface AccountReportGenerator extends ReportGenerator:   \t\t\tString generateFormat()\n" +
                "\t\tclass AccountReportGeneratorHml implements AccountReportGenerator:  \t\t\t@Override String generateFormat()\n" +
                "\t\tclass AccountReportGeneratorJson implements AccountReportGenerator:   \t\t\t@Override String generateFormat()\n" +
                "\tinterface DocumentReportGenerator extends ReportGenerator:   \t\t\tString generateFormat()\n" +
                "\t\tclass DocumentReportGeneratorHml implements DocumentReportGenerator:   \t\t\t@Override String generateFormat()\n" +
                "\t\tclass DocumentReportGeneratorJson implements DocumentReportGenerator:   \t\t@Override String generateFormat()\n"







        );
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("WORK 3:");
        System.out.println("Вызов метода greet без аргументов:");
        System.out.println(new Greeter().greet()); // ввод команды, которой нет - вызов по умолчанию
        System.out.println("Вызов метода greet с аргументом Formality.intimate:");
        System.out.println(new Greeter().greet(Formality.intimate)); // ввод команды
    }
}