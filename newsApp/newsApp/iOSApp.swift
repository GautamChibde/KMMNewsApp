import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
            ContentView(articleHome: HomePageResults(topNews: Article.Companion().dummyData.first, articles: Article.Companion().dummyData))
		}
	}
}
