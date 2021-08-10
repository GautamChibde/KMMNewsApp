import SwiftUI
import shared

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
    var body: some Scene {
        WindowGroup {
            TabView {
                FeedsPage()
                    .tabItem {
                        Image(systemName: "house.fill")
                        Text("Feeds")
                    }
                SearchPage()
                    .tabItem {
                        Image(systemName: "magnifyingglass")
                        Text("Search")
                    }
                DiscoverPage()
                    .tabItem {
                        Image(systemName: "safari")
                        Text("Discover")
                    }
            }
        }
    }
}
