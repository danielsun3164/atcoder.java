package other.math_and_algorithm;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem100Test extends TestBase {

	private static final double TOLERANCE = 1E-7d;

	@Test
	void case1() {
		check(5, "0.10 0.20 0.30 2\n" + "0.02 0.03 0.01 3\n" + "0.50 0.00 0.00 16\n" + "0.20 0.70 0.60 12345\n"
				+ "1.00 1.00 1.00 10000000",
				new double[] { 1.210000000000000d, 1.027637000000000d, 0.000015258789062d, 1.852941176470589d,
						1.000000000000000d },
				new double[] { 1.120000000000000d, 0.942080000000000d, 1.000000000000000d, 0.529411764705882d,
						1.000000000000000d },
				new double[] { 0.670000000000000d, 1.030283000000000d, 1.999984741210938d, 0.617647058823530d,
						1.000000000000000d });
	}

	void check(int q, String input, double[] a, double[] b, double[] c) {
		in.input(q);
		in.input(input);
		execute();
		try (InputStream is = new ByteArrayInputStream(out.toByteArray()); Scanner scanner = new Scanner(is)) {
			IntStream.range(0, q).forEach(i -> {
				double aa = scanner.nextDouble(), ab = scanner.nextDouble(), ac = scanner.nextDouble();
				assertNumberIsAbout(a[i], aa, TOLERANCE);
				assertNumberIsAbout(b[i], ab, TOLERANCE);
				assertNumberIsAbout(c[i], ac, TOLERANCE);
			});
		} catch (IOException e) {
			fail(e);
		}
	}
}
