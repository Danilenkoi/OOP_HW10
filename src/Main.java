import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

//Задание 1
        System.out.println("Задание 1");

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate1.test(3));

        Predicate<Integer> predicate2 = i -> i > 0;
        System.out.println(predicate2.test(-5));

//Задание 2
        System.out.println("Задание 2");

        Name name1 = new Name("Marina");
        Name name2 = new Name("Ilia");

        Consumer<Name> nameConsumer = new Consumer<Name>() {
            @Override
            public void accept(Name name) {
                System.out.println(name + " добрый день!");
            }
        };
        nameConsumer.accept(name2);

        Consumer<Name> nameConsumer1 = name -> System.out.println(name + " добрый день!");
        nameConsumer1.accept(name1);

//Задание 3
        System.out.println("Задание 3");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        Function<Double, Long> function1 = numbers -> Math.round(numbers);

//Задание 4
        System.out.println("Задание 4");

        Supplier <Integer> randomSupplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(randomSupplier.get());

        Supplier <Integer> randomSupplier1 = () -> (int) (Math.random() * 100);
        System.out.println(randomSupplier1.get());

//Задание 5 (Дополнительное)
        System.out.println("Задание 5 (Дополнительное)");

        Predicate <Name> condition = h -> h.name.contains("a");
        Function <Name, String> ifTrue = Object::toString;
        Function <Name, String> ifFalse = s -> "False";

        System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(name2));

        Supplier <Name> supName = () -> new Name(Character.getName(randomSupplier1.get()));

        Name ivan = new Name("Ivan");
        Consumer <Name> cons = h -> System.out.println(ternaryOperator(condition, ifTrue, ifFalse).apply(h));
        cons.accept(supName.get());
    }

    public static <T, U> Function <T, U> ternaryOperator(
            Predicate <? super T> condition,
            Function <? super T, ? extends U> ifTrue,
            Function <? super T, ? extends U> ifFalse) {
        return x -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}