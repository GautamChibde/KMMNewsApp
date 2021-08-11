//
//  SearchViewModel.swift
//  SearchViewModel
//
//  Created by Gautam on 11/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class SearchViewModel: ObservableObject {
    
    @Published var articles = [Article]()
    
    lazy var adapter = NativeSearchIntaractor(
        onLoading: {
            
        }, onSuccess: { data in
            self.articles = data
        }, onError: { error in
            
        }, onEmpty: {
            
        })
    
    func searchArticles(query: String) {
        adapter.searchResults(query: query)
    }
    
    func dispose() {
        adapter.dispose()
    }
}
