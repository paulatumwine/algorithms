public class Lambdas {

    private String value = "Enclosing scope value";

    public String scopeExperiment() {
        Foo fooIC = new Foo() {
            String value = "Inner class value";

            @Override
            public String method(String string) {
                return this.value;
            }
        };
        String resultIC = fooIC.method("");

        Foo fooLambda = parameter -> {
            String value = "Lambda value";
            return this.value;
        };
        String resultLambda = fooLambda.method("");

        return "Results: resultIC = " + resultIC +
                ", resultLambda = " + resultLambda;
    }

    public static void main(String[] args) {
        System.out.println(new Lambdas().scopeExperiment());
    }
}

@FunctionalInterface
interface Foo {
    String method(String string);
    default void defaultMethod() {}
}
