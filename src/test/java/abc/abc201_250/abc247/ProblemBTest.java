package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "tanaka taro\n" + "tanaka jiro\n" + "suzuki hanako", "Yes");
	}

	@Test
	void case2() {
		check("3\n" + "aaa bbb\n" + "xxx aaa\n" + "bbb yyy", "No");
	}

	@Test
	void case3() {
		check("2\n" + "tanaka taro\n" + "tanaka taro", "No");
	}

	@Test
	void case4() {
		check("3\n" + "takahashi chokudai\n" + "aoki kensho\n" + "snu ke", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/B");
	}
}
