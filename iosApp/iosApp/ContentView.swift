import SwiftUI
import SharedLogic

struct ContentView: View {
    @State private var showContent = false
    @State private var frames: [Frame] = []
    private let store = IosFrameStore()

    var body: some View {
        VStack {
            // ... existing code ...

            Button("Aggiungi frame") {
                store.insert(title: "Frame", content: "Test")
            }

            List(frames, id: \.id) { frame in
                Text(frame.title)
            }
        }
        // ... existing code ...
        .onAppear {
            store.observe { newFrames in
                frames = newFrames
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}