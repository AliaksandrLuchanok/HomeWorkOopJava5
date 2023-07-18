package HomeWorkOopJava5.view;

public enum SortType { //специальный класс, сам создаст, сам реализует объекты с фиксированными названиями

    NONE("Сортировка по умолчанию"), NAME("Сортировка по имени"), ID("Сортировка по ИД") // можно через тело NONE {} - реализовывать различную логику
    ;

    @Override
    public String toString() {
        return sortName; // выводим sortName
    }
    private final String sortName;

    SortType(String sortName) {
        this.sortName = sortName; // для именования каждого объекта
    }
}
