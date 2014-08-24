package jag.batch.dao

import jag.batch.model.Book

trait BookDao {
	def save(book: Book): Unit
	def find(id: Int): Option[Book]
}