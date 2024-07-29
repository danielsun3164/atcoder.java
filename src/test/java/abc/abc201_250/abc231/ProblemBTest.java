package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "snuke\n" + "snuke\n" + "takahashi\n" + "takahashi\n" + "takahashi", "takahashi");
	}

	@Test
	void case2() {
		check("5\n" + "takahashi\n" + "takahashi\n" + "aoki\n" + "takahashi\n" + "snuke", "takahashi");
	}

	@Test
	void case3() {
		check("1\n" + "a", "a");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/B");
	}
}
