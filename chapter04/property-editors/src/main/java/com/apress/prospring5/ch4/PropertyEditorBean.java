package com.apress.prospring5.ch4;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyEditorBean {
    private byte[] bytes;                 // ByteArrayPropertyEditor
    private Character character;          // CharacterEditor
    private Class cls;                    // ClassEditor
    private Boolean trueOrFalse;          // CustomBooleanEditor
    private List<String> stringList;      // CustomCollectionEditor
    private Date date;                    // CustomDateEditor
    private Float floatValue;             // CustomNumberEditor
    private File file;                    // FileEditor
    private InputStream stream;           // InputStreamEditor
    private Locale locale;                // LocaleEditor
    private Pattern pattern;              // PatternEditor
    private Properties properties;        // PropertiesEditor
    private String trimString;            // StringTrimmerEditor
    private URL url;                      // URLEditor

    public void setCharacter(Character character) {
        System.out.println("Character 설정: " + character);
        this.character = character;
    }

    public void setCls(Class cls) {
        System.out.println("Class 설정: " + cls.getName());
        this.cls = cls;
    }

    public void setFile(File file) {
        System.out.println("File 설정: " + file.getName());
        this.file = file;
    }

    public void setLocale(Locale locale) {
        System.out.println("Locale 설정: " + locale.getDisplayName());
        this.locale = locale;
    }

    public void setProperties(Properties properties) {
        System.out.println("읽어들인 Properties 개수 : " + properties.size() + "개");
        this.properties = properties;
    }

    public void setUrl(URL url) {
        System.out.println("URL 설정: " + url.toExternalForm());
        this.url = url;
    }

    public void setBytes(byte... bytes) {
        System.out.println("bytes 설정: " + Arrays.toString(bytes));
        this.bytes = bytes;
    }

    public void setTrueOrFalse(Boolean trueOrFalse) {
        System.out.println("Boolean 설정: " + trueOrFalse);
        this.trueOrFalse = trueOrFalse;
    }

    public void setStringList(List<String> stringList) {
        System.out.println("String 목록 설정. 크기: "
            + stringList.size());

        this.stringList = stringList;

        for (String string: stringList) {
            System.out.println("  String 멤버: " + string);
        }
    }

    public void setDate(Date date) {
        System.out.println("Date 설정: " + date);
        this.date = date;
    }

    public void setFloatValue(Float floatValue) {
        System.out.println("Float 값 설정: " + floatValue);
        this.floatValue = floatValue;
    }

    public void setStream(InputStream stream) {
        System.out.println("Stream 설정: " + stream);
        this.stream = stream;
    }

    public void setPattern(Pattern pattern) {
        System.out.println("Pattern 설정: " + pattern);
        this.pattern = pattern;
    }

    public void setTrimString(String trimString) {
        System.out.println("문자열 trim 설정: " + trimString);
        this.trimString = trimString;
    }

    public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar { 
        @Override
        public void registerCustomEditors(PropertyEditorRegistry registry) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
            registry.registerCustomEditor(Date.class, 
                     new CustomDateEditor(dateFormatter, true));

            registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
        }
    }

    public static void main(String... args) throws Exception {
        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-01.xml");
        ctx.refresh();

        PropertyEditorBean bean = 
            (PropertyEditorBean) ctx.getBean("builtInSample");

        ctx.close();
    }
}
