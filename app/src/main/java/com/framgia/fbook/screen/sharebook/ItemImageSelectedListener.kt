package com.framgia.fbook.screen.sharebook

import com.framgia.fbook.data.source.remote.api.request.BookRequest

interface ItemImageSelectedListener {
  fun onRemoveSelected(image: BookRequest.Image)
}
