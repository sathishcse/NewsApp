package com.example.newsapp.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

inline fun <ResultType,RequestType>networkBoundResource(
    crossinline query:() -> Flow<ResultType>,
    crossinline fetch:suspend () -> RequestType,
    crossinline saveFetchResult:suspend (RequestType) -> Unit,
    crossinline shouldFetch:(ResultType) -> Boolean = { true }
) = flow {
    val data = query().first()

    val flow = if(shouldFetch(data)){
        emit(ViewStatus.Loading())
        try {
            saveFetchResult(fetch())
            query().map { ViewStatus.Success(it) }
        }catch(throwable:Throwable){
            query().map { throwable.message?.let { it1 -> ViewStatus.Error(it1) } }
        }
    }else{
        query().map { ViewStatus.Success(it) }
    }
    emitAll(flow)
}