//
//  ArticleItemRow.swift
//  newsApp
//
//  Created by Gautam on 05/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct ArticleItemRow: View {
    var article: Article
    
    var body: some View {
        VStack {
            VStack {
                AsyncImage(url: URL(string: "https://www.cnn.com/2021/06/17/business/china-ports-global-supply-chain-intl-hnk/index.html")) { image in
                    image.scaledToFit()
                } placeholder: {
                    ProgressView()
                }
                Text(article.title)
                    .foregroundColor(Color.black)
                    .lineLimit(2)
                    .font(.title)
                Text(article.publishedAt)
                    .font(.subheadline)
                    .foregroundColor(.gray)
                    .lineLimit(1)
            }
        }
    }
}

struct ArticleItemRow_Previews: PreviewProvider {
    static var previews: some View {
        ArticleItemRow(article: Article.Companion().dummyData[1])
    }
}
