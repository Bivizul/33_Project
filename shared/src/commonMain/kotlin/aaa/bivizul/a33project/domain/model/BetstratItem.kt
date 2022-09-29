package aaa.bivizul.a33project.domain.model

@kotlinx.serialization.Serializable
data class BetstratItem(
    val id: Int,
    val betstrattitle: String,
    val betstratdesc: String,
    val betstratin: List<Betstratin>,
)