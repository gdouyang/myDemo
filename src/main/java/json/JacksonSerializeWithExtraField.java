package json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.fasterxml.jackson.databind.ser.impl.BeanAsArraySerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;

public class JacksonSerializeWithExtraField {

	@Test
	public void testAddExtraField() throws Exception {
		ObjectMapper mapper = new ObjectMapper();

		mapper.registerModule(new SimpleModule() {

			private static final long serialVersionUID = -1115386665677792836L;

			public void setupModule(SetupContext context) {
				super.setupModule(context);

				context.addBeanSerializerModifier(new BeanSerializerModifier() {

					public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc,
							JsonSerializer<?> serializer) {
						if (serializer instanceof BeanSerializerBase) {
							return new ExtraFieldSerializer((BeanSerializerBase) serializer);
						}
						return serializer;

					}
				});
			}
		});

		List<MyClass> list = new ArrayList<>();
		list.add(new MyClass());

		System.out.println(mapper.writeValueAsString(list));
		System.out.println(mapper.writeValueAsString(new MyClass()));
		System.out.println(mapper.writeValueAsString("adfadfa"));
		System.out.println(mapper.writeValueAsString(new Date()));
		System.out.println(mapper.writeValueAsString(1));
		System.out.println(mapper.writeValueAsString(new SimpleDateFormat()));
		// prints {"classField":"classFieldValue","extraField":"extraFieldValue"}
	}

	class MyClass {

		private String classField = "classFieldValue";

		public String getClassField() {
			return classField;
		}

		public void setClassField(String classField) {
			this.classField = classField;
		}
	}

	class ExtraFieldSerializer extends BeanSerializerBase {

		private static final long serialVersionUID = 29;

		protected ExtraFieldSerializer(BeanSerializerBase source) {
			super(source);
		}

		protected ExtraFieldSerializer(ExtraFieldSerializer source, ObjectIdWriter objectIdWriter) {
			super(source, objectIdWriter);
		}

		protected ExtraFieldSerializer(ExtraFieldSerializer source, Set<String> toIgnore) {
			super(source, toIgnore);
		}
		
		protected ExtraFieldSerializer(BeanSerializerBase src,
	            ObjectIdWriter objectIdWriter, Object filterId) {
	        super(src, objectIdWriter, filterId);
	    }

		@Override
		public BeanSerializerBase withObjectIdWriter(ObjectIdWriter objectIdWriter) {
			return new ExtraFieldSerializer(this, objectIdWriter);
		}

		public void serialize(Object bean, JsonGenerator jgen, SerializerProvider provider)
				throws IOException, JsonGenerationException {
			jgen.writeStartObject();
			serializeFields(bean, jgen, provider);
			jgen.writeStringField("extraField", "extraFieldValue");
			jgen.writeEndObject();
		}

		@Override
		protected BeanSerializerBase withIgnorals(Set<String> toIgnore) {
			return new ExtraFieldSerializer(this, toIgnore);
		}

		@Override
		protected BeanSerializerBase asArraySerializer() {
			if ((_objectIdWriter == null)
	                && (_anyGetterWriter == null)
	                && (_propertyFilterId == null)
	                ) {
	            return new BeanAsArraySerializer(this);
	        }
	        // already is one, so:
	        return this;
		}

		@Override
		public BeanSerializerBase withFilterId(Object filterId) {
			return new ExtraFieldSerializer(this, _objectIdWriter, filterId);
		}
	}
}