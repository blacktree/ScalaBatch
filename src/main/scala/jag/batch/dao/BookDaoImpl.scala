package jag.batch.dao

import jag.batch.model.Book
import org.springframework.transaction.annotation.{Propagation, Transactional}
import org.springframework.stereotype.Repository
import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import org.hibernate.criterion.Restrictions

@Repository
@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
class BookDaoImpl extends BookDao {
  
	@Autowired
	var sessionFactory: SessionFactory = _
  
	def save(book: Book): Unit = book.id match {
	  case 0 => sessionFactory.getCurrentSession().save(book)
	  case _ => sessionFactory.getCurrentSession().merge(book)
	}
	
	def find(id: Int): Option[Book] = sessionFactory.getCurrentSession().get(classOf[Book], id) match {
	    case null => None
	    case _@result => Option(result.asInstanceOf[Book])
	}
}