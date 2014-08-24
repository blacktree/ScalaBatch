package jag.batch.reader

import java.io.Serializable
import org.springframework.batch.item.ItemReader
import jag.batch.domain.DummyItem

class DummyReader extends ItemReader[DummyItem] {
	var count = 10;
  
	def read: DummyItem = {
	  count = count - 1
	  if (count >= 0) new DummyItem else null
	}
}