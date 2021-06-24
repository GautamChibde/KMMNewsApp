package com.example.newsapp.model

data class Article(
    val author: String,
    val description: String,
    val publishedAt: String,
    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String
) {
    companion object {
        val dummyData = listOf(
            Article(
                author = "1Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210616031524-china-ports-global-supply-chain-intl-hnk-restricted-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
                source = Source(
                    null,
                    "New York Times"
                )
            ),
            Article(
                author = "2Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://static.foxnews.com/foxnews.com/content/uploads/2021/06/AP21173248571574.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
                source = Source(
                    null,
                    "New York Times"
                )
            ),
            Article(
                author = "3Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210621233036-florida-manatee-county-coronavirus-outbreak-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
                source = Source(
                    null,
                    "New York Times"
                )
            ),
            Article(
                author = "4Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210622012019-myanmar-mandalay-fighting-intl-hnk-map-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
                source = Source(
                    null,
                    "New York Times"
                )
            )
        )
    }
}