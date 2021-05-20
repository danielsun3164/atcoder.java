package abc.abc201_250.abc201;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "Everest 8849\n" + "K2 8611\n" + "Kangchenjunga 8586", "K2");
	}

	@Test
	void case2() {
		check("4\n" + "Kita 3193\n" + "Aino 3189\n" + "Fuji 3776\n" + "Okuhotaka 3190", "Kita");
	}

	@Test
	void case3() {
		check("4\n" + "QCFium 2846\n" + "chokudai 2992\n" + "kyoprofriends 2432\n" + "penguinman 2390", "QCFium");
	}
}
