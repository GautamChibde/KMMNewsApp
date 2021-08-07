import SwiftUI
import shared

struct Art: Identifiable, Hashable {
    let title: String
    let id = UUID()
}


extension Article : Identifiable {
    public var id: UUID { return UUID() }
}

struct ContentView: View {
    @State var articleHome: HomePageResults
    
    var adapter: HomePageViewModel = HomePageViewModel(
        onLoading: {
            
        }, onSuccess: { data in
            print("success")
        }, onError: { error in
            print("error " + error)
        }, onEmpty: {
            
        }
    )
    
	var body: some View {
      Text("something")
        List(articleHome.articles) { item in
            ArticleItemRow(article: item)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        ContentView(articleHome: HomePageResults(topNews: Article.Companion().dummyData.first, articles: Article.Companion().dummyData))
	}
}
