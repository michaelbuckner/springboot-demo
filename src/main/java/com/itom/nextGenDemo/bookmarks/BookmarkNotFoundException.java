package com.itom.nextGenDemo.bookmarks;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookmarkNotFoundException extends RuntimeException {

	public BookmarkNotFoundException(String userId) {
		super("could not find bookmark '" + userId + "'.");
	}
}