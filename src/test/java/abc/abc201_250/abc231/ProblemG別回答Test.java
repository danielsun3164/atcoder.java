package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 1\n" + "1 2 3", "665496245");
	}

	@Test
	void case2() {
		check("2 2\n" + "1 2", "499122182");
	}

	@Test
	void case3() {
		check("10 1000000000\n"
				+ "998244350 998244351 998244352 998244353 998244354 998244355 998244356 998244357 998244358 998244359",
				"138512322");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/G");
	}
}
