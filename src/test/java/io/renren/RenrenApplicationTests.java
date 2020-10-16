package io.renren;

import org.apache.commons.lang.WordUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenrenApplicationTests {

	@Test
	public void contextLoads() {
        String str = tableToJava("wsc_token_app", null);
        System.out.println(str);
    }

    public static String tableToJava(String tableName, String[] tablePrefixArray) {
        if(null != tablePrefixArray && tablePrefixArray.length>0){
            for(String tablePrefix : tablePrefixArray){
                tableName = tableName.replace(tablePrefix, "");
            }
        }
        return columnToJava(tableName);
    }

    public static String columnToJava(String columnName) {
        return WordUtils.capitalize(columnName, new char[]{'_'}).replace("_", "" );
    }

}
