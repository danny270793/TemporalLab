package helloworkflow;

public class Starter {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new Starter().getGreeting());
    }
}
