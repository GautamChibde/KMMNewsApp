//
//  TopNewsView.swift
//  TopNewsView
//
//  Created by Gautam on 09/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared

struct TopNewsView: View {
    var article: Article
    
    var body: some View {
        VStack {
            
        }
    }
}

struct TopNewsView_Previews: PreviewProvider {
    static var previews: some View {
        TopNewsView(article: Article.Companion().dummyData[1])
    }
}
