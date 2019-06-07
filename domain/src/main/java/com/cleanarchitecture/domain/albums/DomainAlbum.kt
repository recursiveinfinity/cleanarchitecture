package com.cleanarchitecture.domain.albums

data class DomainAlbum(
        var userId: String? = null,
        var description: String? = null,
        var url: String? = null
)