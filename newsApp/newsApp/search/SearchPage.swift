//
//  SearchPage.swift
//  SearchPage
//
//  Created by Gautam on 09/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SearchPage: View {
    @State private var username: String = ""
    @State private var isEditing = false
    
    @StateObject var viewModel = SearchViewModel()
    
    var body: some View {
        VStack(alignment: .leading) {
            HStack(alignment: .center) {
                TextField(
                    "User name (email address)",
                    text: $username
                ) { isEditing in
                    self.isEditing = isEditing
                } onCommit: {
                    print("username")
                }.autocapitalization(.none)
                    .disableAutocorrection(true)
                    .frame(height: 56)
                
                Button("Search", action: {
                    viewModel.searchArticles(query: username)
                })
            }.padding(16)
            
            List(viewModel.articles) { article in
                HStack(alignment: .top) {
                    AsyncImage(url: URL(string: article.urlToImage ?? "")) { image in
                        image
                            .resizable()
                            .aspectRatio(contentMode: .fill)
                    } placeholder: {
                        ProgressView()
                    }.frame(width: 80, height: 120)
                    
                    VStack(alignment: .leading, spacing: 10) {
                        Text(article.title)
                            .font(.system(size: 15, weight: .bold, design: .default))
                            .foregroundColor(.black)
                            .lineLimit(2)
                        Text(article.description_ ?? "")
                            .font(.system(size: 14))
                            .foregroundColor(.gray)
                            .lineLimit(1)
                        Text(article.source.name)
                            .font(.system(size: 14))
                            .foregroundColor(.gray)
                            .lineLimit(1)
                    }
                }.frame(height: 120)
                    .padding(16)
            }
        }.onAppear {
            
        }.onDisappear {
            
        }
    }
    
    func search() {
        
    }
}

struct SearchPage_Previews: PreviewProvider {
    static var previews: some View {
        SearchPage()
    }
}
