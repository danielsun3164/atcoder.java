package abc.abc101_150.abc135;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("??2??5", "768");
	}

	@Test
	void case2() {
		check("?44", "1");
	}

	@Test
	void case3() {
		check("7?4", "0");
	}

	@Test
	void case4() {
		check("?6?42???8??2??06243????9??3???7258??5??7???????774????4?1??17???9?5?70???76???", "153716888");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/D");
	}
}
