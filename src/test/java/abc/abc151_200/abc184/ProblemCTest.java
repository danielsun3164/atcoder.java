package abc.abc151_200.abc184;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1 1\n" + "5 6", "2");
	}

	@Test
	void case2() {
		check("1 1\n" + "1 200001", "2");
	}

	@Test
	void case3() {
		check("2 3\n" + "998244353 998244853", "3");
	}

	@Test
	void case4() {
		check("1 1\n" + "1 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC184/C");
	}
}
