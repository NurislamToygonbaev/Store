public class MyIdGenerator {
    public static long counter = 0;

    public static long generatorId(){
        return ++counter;
    }
}
