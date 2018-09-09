package com.squareup.picasso

fun Picasso.clearCache() {
    cache.clear()
}

fun Picasso.clearCache(url: String) {
    cache.clearKeyUri(url)
}