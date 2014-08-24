package jag.batch.model

import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.GenerationType
import scala.beans.BeanProperty

@Entity
@Table(name="books")
class Book(a: String, t: String) {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@BeanProperty
	var id: Int = _

	@BeanProperty
	var author = a
	
	@BeanProperty
	var title = t
	
	def this() = this(null, null)
	
	override def toString = id + " = " + author + " " + title
}