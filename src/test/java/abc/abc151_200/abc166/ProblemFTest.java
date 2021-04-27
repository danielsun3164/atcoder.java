package abc.abc151_200.abc166;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check(2, 1, 3, 0, new String[] { "AB", "AC" });
	}

	@Test
	void case2() {
		check("3 1 0 0\n" + "AB\n" + "BC\n" + "AB", "No");
	}

	@Test
	void case3() {
		check("1 0 9 0\n" + "AC", "No");
	}

	@Test
	void case4() {
		check(8, 6, 9, 1, new String[] { "AC", "BC", "AB", "BC", "AC", "BC", "AB", "AB" });
	}

	private void check(int n, int a, int b, int c, String[] s) {
		in.input(n + " " + a + " " + b + " " + c);
		in.input(Arrays.stream(s).collect(Collectors.joining("\n")));
		execute();
		try (ByteArrayInputStream bais = new ByteArrayInputStream(out.toByteArray());
				Scanner scanner = new Scanner(bais)) {
			assertEquals("Yes", scanner.next());
			for (int i = 0; i < n; i++) {
				String r = scanner.next();
				assertTrue(s[i].contains(r));
				switch (r) {
				case "A":
					a++;
					break;
				case "B":
					b++;
					break;
				case "C":
				default:
					c++;
					break;
				}
				switch (s[i].replace(r, "")) {
				case "A":
					a--;
					assertTrue(a >= 0, "a is " + a);
					break;
				case "B":
					b--;
					assertTrue(b >= 0, "b is " + b);
					break;
				case "C":
				default:
					c--;
					assertTrue(c >= 0, "c is " + c);
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail(e);
		}
	}
}
