//
//  FeedsViewModel.swift
//  FeedsViewModel
//
//  Created by Gautam on 09/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class FeedsViewModel: ObservableObject {
    
    @Published var articles = [Article]()
    @Published var topNews: Article?
    
    lazy var adapter = NativeFeedsIntaractor(
        onLoading: {
        }, onSuccess: {[self] data in
            self.articles = data.articles
            self.topNews = data.topNews
        }, onError: { error in
        }, onEmpty: {
        }
    )
    
    func fetchResults() {
        adapter.fetchResults()
    }
    
    func dispose() {
        adapter.onDestroy()
    }
}
