// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// SAM_CONVERSIONS: INDY

fun interface IFoo {
    fun foo(): String
}

fun foo(iFoo: IFoo) = iFoo.foo()

fun box(): String {
    try {
        foo { throw RuntimeException("OK") }
    } catch (e: RuntimeException) {
        return e.message!!
    }
    return "Failed"
}
