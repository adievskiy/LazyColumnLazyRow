package com.example.lazycolumnlazyrow

data class Book(val image: Int, val name: String, val price: Int) {
    companion object {
        val list = mutableListOf(
            Book(R.drawable.part_01, "Философский камень", 50000),
            Book(R.drawable.part_02, "Тайная комната", 50000),
            Book(R.drawable.part_03, "Узник Азкабана",100000),
            Book(R.drawable.part_04, "Кубок огня",50000),
            Book(R.drawable.part_05, "Орден Феникса",50000),
            Book(R.drawable.part_06, "Принц-полукровка",50000),
            Book(R.drawable.part_07, "Дары Смерти",50000),
        )
    }
}