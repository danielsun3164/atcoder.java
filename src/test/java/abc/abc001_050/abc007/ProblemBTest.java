package abc.abc001_050.abc007;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("xyz");
	}

	@Test
	void case2() {
		check("b");
	}

	@Test
	void case3() {
		check("a", "-1");
	}

	@Test
	void case4() {
		check("aaaaa");
	}

	private void check(String input) {
		in.input(input);
		execute();
		String[] lines = out.toString().split("\\R");
		assertEquals(1, lines.length);
		assertFalse(lines[0].isEmpty(), "value is empty");
		assertTrue(lines[0].compareTo(input) < 0, "value is " + lines[0]);
	}
}
