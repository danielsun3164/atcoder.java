package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("mari\n" + "to\n" + "zzo\n" + "1321", "marizzotomari");
	}

	@Test
	void case2() {
		check("abra\n" + "cad\n" + "abra\n" + "123", "abracadabra");
	}

	@Test
	void case3() {
		check("a\n" + "b\n" + "c\n" + "1", "a");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/B");
	}
}
