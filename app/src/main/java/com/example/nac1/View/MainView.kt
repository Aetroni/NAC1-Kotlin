package com.example.nac1.View

import com.example.nac1.Model.CardItem

interface MainView {

        fun requestData(listCards: ArrayList<CardItem>)
        fun cardClickOk(idImgCard: Int)
        fun cardClickFail()
        fun sendActionMain(cardOption: Int, indexArray: Int)


}