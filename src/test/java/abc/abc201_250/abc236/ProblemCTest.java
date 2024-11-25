package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "tokyo kanda akiba okachi ueno\n" + "tokyo akiba ueno",
				"Yes" + LF + "No" + LF + "Yes" + LF + "No" + LF + "Yes");
	}

	@Test
	void case2() {
		check("7 7\n" + "a t c o d e r\n" + "a t c o d e r",
				"Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/C");
	}
}
