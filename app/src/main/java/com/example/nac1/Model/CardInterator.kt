package com.example.nac1.Model

class CardInterator {

    interface OnFinishedListener{
        fun onResultSucess(listOKCard: ArrayList<CardItem>)
        fun onResultFail(errorMsg: String)
    }

    fun requestData(onFinishedListener: OnFinishedListener){

        var list = LocalData.fillArray()

        if (list.isEmpty()){
            onFinishedListener.onResultFail("No hay datos disponibles")
        }else{
            onFinishedListener.onResultSucess(list)
        }
    }
}