package js;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

public class JSTest1 {
  
  public static void main(String args[]){
    
//    ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
//    ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
    NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
    ScriptEngine nashorn = factory.getScriptEngine(new String[]{"-strict", "--no-java", "--no-syntax-extensions"});
      
    String name = "Runoob";
    Integer result = null;
    
    try {
      nashorn.put("jsObj", new JSObj());
//      System.out.println(nashorn.eval("jsObj.hello()"));
       nashorn.eval("eval(\"java.lang.System.out.println('" + name + "')\")");
       result = (Integer) nashorn.eval("10 + 2");
       
    }catch(ScriptException e){
       System.out.println("执行脚本错误: "+ e.getMessage());
    }
    
    System.out.println(result.toString());
 }
  
  
}