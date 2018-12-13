package com.wtr.core.domain

class NoLastKnownLocation(error: String = "Last location is null") : RuntimeException(error)

class LocationIsNotAvailable(error: String = "Location is not available") : RuntimeException(error)