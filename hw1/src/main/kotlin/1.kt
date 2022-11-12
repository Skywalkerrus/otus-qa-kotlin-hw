interface TestRunner {
    fun runTest(steps: T, test: () -> Unit)
}

class T : TestRunner {
    fun before() {
        println("before")
    }

    fun after(){
        println("after")
    }

    fun testOutput() {
        println("test OUTPUT")
    }

    override fun runTest(steps: T, test: () -> Unit) {
        steps.before()
        test()
        steps.after()
    }
}

fun main()
{
   T().runTest(T(), { T().testOutput() })
}