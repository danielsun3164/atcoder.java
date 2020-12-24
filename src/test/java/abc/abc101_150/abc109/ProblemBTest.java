package abc.abc101_150.abc109;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "hoge\n" + "english\n" + "hoge\n" + "enigma", "No");
	}

	@Test
	void case2() {
		check("9\n" + "basic\n" + "c\n" + "cpp\n" + "php\n" + "python\n" + "nadesico\n" + "ocaml\n" + "lua\n"
				+ "assembly", "Yes");
	}

	@Test
	void case3() {
		check("8\n" + "a\n" + "aa\n" + "aaa\n" + "aaaa\n" + "aaaaa\n" + "aaaaaa\n" + "aaa\n" + "aaaaaaa", "No");
	}

	@Test
	void case4() {
		check("3\n" + "abc\n" + "arc\n" + "agc", "No");
	}
}
