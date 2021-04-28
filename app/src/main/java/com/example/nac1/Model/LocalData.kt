package com.example.nac1.Model

import com.example.nac1.R

class LocalData {

    companion object{

        val listFullCards = ArrayList<CardItem>()

        init {

            listFullCards.add(
                CardItem(
                    R.drawable.ic_discord,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_github,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_open_source,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_team_viewer,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_twitch,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_wordpress,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_react,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_kotlin,
                    R.drawable.ic_information,
                    false
                )
            )

            listFullCards.add(
                CardItem(
                    R.drawable.ic_discord,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_github,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_open_source,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_team_viewer,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_twitch,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_wordpress,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_react,
                    R.drawable.ic_information,
                    false
                )
            )
            listFullCards.add(
                CardItem(
                    R.drawable.ic_kotlin,
                    R.drawable.ic_information,
                    false
                )
            )

            listFullCards.shuffle()
        }

        fun fillArray(): ArrayList<CardItem>{
            return listFullCards
        }
    }
}