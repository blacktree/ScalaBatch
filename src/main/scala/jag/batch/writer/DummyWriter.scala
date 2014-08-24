package jag.batch.writer

import java.util.List
import org.springframework.batch.item.ItemWriter
import jag.batch.domain.DummyItem

class DummyWriter extends ItemWriter[DummyItem] {
	def write(items: List[_ <: DummyItem]): Unit = {
	  
	}
}