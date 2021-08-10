//
//  Extensions.swift
//  Extensions
//
//  Created by Gautam on 09/08/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

extension Article : Identifiable {
    public var id: UUID { return UUID() }
}
