package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;

import beanutils.entity.ClassRoom;
import beanutils.entity.Student;

/***
 * PropertyUtils.describe方法中的参数,bean里面的要有get方法,boolean类型的可以为get/is方法
 * 不一定需要有成员变量，它只会通过get方法去截取出所谓的变量名
 * (就算定义了public的变量但没有get方法也是不会有值的)，getxxnum()得到的变量名为xxnum
 * 默认为有一个class的变量，应该在Object类中有定义class变量所以给继承下来了
 * 
 * /Users/Snake/.m2/repository/commons-logging/commons-logging/1.1.1/commons-logging-1.1.1-sources.jar
 * @author snake 2014-10-25-上午9:43:01
 */
public class TestPropertyUtils {
	public static void main(String[] args) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		ClassRoom room = new ClassRoom();
		room.setName("one class");
		room.setName("abc111");

		Student stu = new Student();

		stu.setAge(25);
		stu.setName("snake");
		stu.setnum("a");
		stu.setClassRoom(room);

		Map<?, ?> map = PropertyUtils.describe(stu);
		map.remove("class");
		System.out.println(map);
	}
}
