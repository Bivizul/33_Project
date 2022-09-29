package aaa.bivizul.a33project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform