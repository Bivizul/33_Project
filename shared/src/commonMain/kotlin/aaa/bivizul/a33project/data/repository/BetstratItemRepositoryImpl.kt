package aaa.bivizul.a33project.data.repository

import aaa.bivizul.a33project.data.network.BetstratApi
import aaa.bivizul.a33project.domain.util.betstratIoDispatcher
import aaa.bivizul.a33project.domain.model.BetstratItem
import aaa.bivizul.a33project.domain.repository.BetstratItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BetstratItemRepositoryImpl : BetstratItemRepository {

    private val betstratApi = BetstratApi()
    private val betstratjob = SupervisorJob()
    private val betstratscope = CoroutineScope(betstratIoDispatcher + betstratjob)

    private val _betstratItemList = MutableStateFlow<List<BetstratItem>?>(null)
    val betstratItemList: StateFlow<List<BetstratItem>?> = _betstratItemList.asStateFlow()

    init {
        getBetstratItem()
    }

    override fun getBetstratItem() {
        betstratscope.launch {
            val response = betstratApi.getBetstratItem()
            _betstratItemList.emit(response)
        }
    }

}