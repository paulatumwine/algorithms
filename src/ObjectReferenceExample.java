public class ObjectReferenceExample {

    public static void main(String... doYourBest) {
        Simpson simpson = new Simpson("Simp");
        transformIntoHomer(simpson);
        System.out.println(simpson.name);
    }

    static void transformIntoHomer(Simpson simpson) {
        simpson.name = "Homer";
    }

}

class Simpson {
    String name;

    public Simpson(String name) {
        this.name = name;
    }
}