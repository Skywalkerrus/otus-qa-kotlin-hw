interface TestRunner {
    fun runTest(steps: T, test: () -> Unit)
}

class T {
}

class diffClass {
    fun ff2() {
        println("func from another class")
    }
}

class stepsClass {

    fun beforeTest() {
        println("before")
    }

    fun afterTest() {
        println("after")
    }
}

class testRun : TestRunner {
    override fun runTest(steps: T, test: () -> Unit) {
        test()
    }

}

fun main()
{
    testRun().runTest(T(), { stepsClass().beforeTest() })
    testRun().runTest(T(), { stepsClass().afterTest() })
    testRun().runTest(T(), {diffClass().ff2()})
}