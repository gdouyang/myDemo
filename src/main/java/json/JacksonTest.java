package json;


import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.JsonParser.NumberType;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JacksonTest
{
	public static void main(String[] args)throws Exception
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.getSerializationConfig().getHandlerInstantiator();
		
		TestBean bean = new TestBean();
		bean.setId(1);
		bean.setDate(new Date());
		bean.setName("aaab<scrip>中中中中中车\"'d");
		ObjectWriter writer = mapper.writer().with(new MyEscapes());
		String s = writer.writeValueAsString(bean);
		
		System.out.println(s);
		ObjectNode json = (ObjectNode) mapper.readTree( s);
		json.put("test", "121");
		
		System.out.println(json);
	}
}
