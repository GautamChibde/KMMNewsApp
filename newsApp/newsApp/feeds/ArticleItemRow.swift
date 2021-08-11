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
            AsyncImage(url: URL(string: article.urlToImage ?? "")) { image in
                image
                    .resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(height: 200)
            } placeholder: {
                ProgressView()
            }
            
            Text(article.title)
                .font(.system(size: 16))
                .foregroundColor(.black)
                .lineLimit(1)
            Text(article.description_ ?? "")
                .font(.system(size: 14))
                .foregroundColor(.gray)
                .lineLimit(2)
            
            HStack {
                Text(article.source.name)
                    .font(.system(size: 14))
                    .foregroundColor(.gray)
                    .lineLimit(1)
                Spacer(minLength: 16)
                Text(article.publishedAt)
                    .font(.system(size: 14))
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
