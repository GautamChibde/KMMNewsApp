import SwiftUI
import shared

struct Art: Identifiable, Hashable {
    let title: String
    let id = UUID()
}

struct ContentView: View {
    let articles = Article.Companion().dummyData.map {Art(title: $0.title)}
    
	var body: some View {
        List(articles) {
            Text($0.title)
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
