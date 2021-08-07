//
//  Koin.swift
//  Koin
//
//  Created by Gautam on 07/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

func startKoin() {
    let doOnStartup = { NSLog("Hello from iOS/Swift!") }
    let koinApplication = KoinIOSKt.doInitKoinIos(doOnStartup: doOnStartup)
    _koin = koinApplication.koin
}

private var _koin: Koin_coreKoin? = nil
var koin: Koin_coreKoin {
    return _koin!
}

