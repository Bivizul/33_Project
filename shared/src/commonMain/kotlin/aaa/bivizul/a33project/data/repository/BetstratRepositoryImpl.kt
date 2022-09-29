package aaa.bivizul.a33project.data.repository

import aaa.bivizul.a33project.data.network.BetstratApi
import aaa.bivizul.a33project.domain.util.betstratIoDispatcher
import aaa.bivizul.a33project.domain.model.Betstrat
import aaa.bivizul.a33project.domain.model.Betstratg
import aaa.bivizul.a33project.domain.repository.BetstratRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class BetstratRepositoryImpl : BetstratRepository{

    private val betstratApi = BetstratApi()
    private val betstratjob = SupervisorJob()
    private val betstratscope = CoroutineScope(betstratIoDispatcher + betstratjob)

    private val _betstratg = MutableStateFlow<Betstratg?>(null)
    val betstratg: StateFlow<Betstratg?> = _betstratg.asStateFlow()

    fun getBetstratg(betstrat: Betstrat) {
        betstratscope.launch {
            val response = betstratApi.getBetstratg(betstrat)
            _betstratg.emit(response)
        }
    }

}