package HomeWorkOopJava6.work3;

public class Greeter {
    private Formality formality;

    public String greet(Formality formality) { //1 вариация - метод с хард-аргументами
           return switch (formality) {
                case formal -> "Good evening, sir.";
                case casual -> "Sup bro?";
                case intimate -> "Hello Darling!";
            };
    }
    public String greet() { //2 вариация - метод без аргументов (по умолчанию)
        return "Hello.";
    }
    public void setFormality(Formality formality) {
        this.formality = formality;
    }
}
