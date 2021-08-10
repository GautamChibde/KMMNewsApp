import SwiftUI
import shared

struct FeedsPage: View {
    @StateObject var viewModel = FeedsViewModel()
    
    var body: some View {
        List(viewModel.articles) { item in
            ArticleItemRow(article: item)
        }.onAppear {
            viewModel.fetchResults()
        }.onDisappear {
            viewModel.dispose()
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        FeedsPage()
    }
}
