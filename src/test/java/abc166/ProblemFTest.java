package abc166;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() throws IOException {
		check(2, 1, 3, 0, new String[] { "AB", "AC" });
	}

	@Test
	void case2() {
		in.input("3 1 0 0\n" + "AB\n" + "BC\n" + "AB");
		ProblemF.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("1 0 9 0\n" + "AC");
		ProblemF.main(null);
		assertResultIs("No");
	}

	@Test
	void case4() throws Exception {
		check(8, 6, 9, 1, new String[] { "AC", "BC", "AB", "BC", "AC", "BC", "AB", "AB" });
	}

	private void check(int n, int a, int b, int c, String[] s) throws IOException {
		in.input(n + " " + a + " " + b + " " + c);
		in.input(Arrays.stream(s).collect(Collectors.joining("\n")));
		ProblemF.main(null);
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
		}
	}
}
