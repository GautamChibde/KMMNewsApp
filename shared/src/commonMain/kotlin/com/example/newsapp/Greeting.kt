package com.example.newsapp

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}

data class Article(
    val title: String,
    val url: String,
    val urlToImage: String,
    val author: String,
    val description: String,
    val publishedAt: String
) {
    companion object {
        val dummyData = listOf(
            Article(
                author = "Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210616031524-china-ports-global-supply-chain-intl-hnk-restricted-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
            ),
            Article(
                author = "Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210616031524-china-ports-global-supply-chain-intl-hnk-restricted-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
            ),
            Article(
                author = "Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210616031524-china-ports-global-supply-chain-intl-hnk-restricted-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
            ),
            Article(
                author = "Laura He, CNN Business",
                title = "A huge backlog at China's ports could spoil your holiday shopping this year - CNN ",
                description = "A coronavirus outbreak in southern China has clogged ports critical to global trade, causing a shipping backlog that could take months to clear and lead to shortages during the year-end holiday shopping season.",
                url = "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html",
                urlToImage = "https://cdn.cnn.com/cnnnext/dam/assets/210616031524-china-ports-global-supply-chain-intl-hnk-restricted-super-tease.jpg",
                publishedAt = "2021-06-18T02:36:00Z",
            )
        )
    }
}