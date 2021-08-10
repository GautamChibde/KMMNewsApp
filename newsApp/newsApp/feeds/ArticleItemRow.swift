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
            
            Text(article.description)
            
            Text(article.source.name)
            
            Tex
                        
//            Text(article.urlToImage ?? "")
//                .font(.system(size: 26, weight: .bold, design: .default))
//                .foregroundColor(.white)
//                .lineLimit(1)
//            Text(article.description)
//                .font(.system(size: 16, weight: .bold, design: .default))
//                .foregroundColor(.gray)
//                .lineLimit(2)
        }
    }
}

struct ArticleItemRow_Previews: PreviewProvider {
    static var previews: some View {
        ArticleItemRow(article: Article.Companion().dummyData[1])
    }
}
