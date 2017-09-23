package json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JacksonTest
{
	public static void main(String[] args)throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.getSerializationConfig().getHandlerInstantiator();
		
		TestBean bean = new TestBean();
		bean.setId(1);
		bean.setName("aaab<scrip>中中中中中车\"'d");
		ObjectWriter writer = mapper.writer().with(new MyEscapes());
		String s = writer.writeValueAsString(bean);
		System.out.println(s);
	}
}
