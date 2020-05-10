import java.util.function.Supplier;
import java.util.stream.LongStream;

public class EratosthenesSieve {
    public static void main(String[] args) {
        long N = 100L;
        StringBuilder sb = new StringBuilder();

        Supplier<LongStream> sup = () -> LongStream.rangeClosed(2, N);
        do {
            sup = filter(sup, sb, (long) Math.sqrt(N));
        } while (sup != null);

        //delete the last ","
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    static Supplier<LongStream> filter(Supplier<LongStream> stream, StringBuilder sb, long sqrt) {
        long l = stream.get().findFirst().getAsLong();
        if (l > sqrt) {
            stream.get().parallel().forEach(i -> sb.append(i + ","));
            return null;
        }
        sb.append(l + ",");
        return () -> stream.get().filter(i -> i % l != 0);
    }
}
