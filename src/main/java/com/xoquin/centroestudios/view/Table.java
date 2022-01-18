package com.xoquin.centroestudios.view;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Table<T> {
    private List<Row> rows;
    private List<T> values;
    private TableStyle style = TableStyle.getTableStyle();

    public Table(T obj){
        values = new ArrayList<>();
        values.add(obj);
        setRows(obj);
    }

    public Table(List<T> objs){
        values = objs;
        setRows(values.get(0));
    }

    private void setRows(T obj){
        rows = new ArrayList<>();
        if(obj == null){
            return;
        }
        for(Field field: obj.getClass().getDeclaredFields()){
            rows.add(new Row(field));
        }

        for (T object : values) {
            Method[] methods = object.getClass().getMethods();
            for(Method method: methods){
                if(!method.getReturnType().equals(Void.TYPE)){
                    for(Row row : rows){
                        String methodname = method.getName().substring(3);
                        methodname = methodname.substring(0, 1).toLowerCase() + methodname.substring(1);
                        if(row.getName().equals(methodname)){
                            try {
                                int valLength = method.invoke(object).toString().length()+2;
                                if(valLength > row.getMaxLength()) row.setMaxLength(valLength);
                            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    private String getBody(){
        String text = "";
        for(T value: values){
            text+=style.getVertical();
            Method[] methods = value.getClass().getMethods();
            for(Row row : rows){
                for(Method method: methods){
                if(!method.getReturnType().equals(Void.TYPE)){
                    String methodname = method.getName().substring(3);
                        methodname = methodname.substring(0, 1).toLowerCase() + methodname.substring(1);
                        if(row.getName().equals(methodname)){
                            try {
                                String cellValue = " "+method.invoke(value).toString()+" ";
                                while(cellValue.length() < row.getMaxLength()){
                                    cellValue+=" ";
                                }
                                text+=cellValue+style.getVertical();
                            }
                            catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                }
            }        
            }
            
            text+="\n";
        }
        return text;
    }

    @Override
    public String toString() {
        if(values.get(0) == null) return "TABLA VACÍA\n";

        String text = style.getVertical();
        for(Row row : rows){
            String fieldValue = " "+row.getName()+" ";
            while(fieldValue.length() < row.getMaxLength()){
                fieldValue+=" ";
            }
            text+= fieldValue + style.getVertical();
        }
        String separator = style.getCross();
        for(Row row : rows){
            String fieldValue = "";
            while(fieldValue.length() < row.getMaxLength()){
                fieldValue+=style.getHorizontal();
            }
            separator+= fieldValue + style.getCross();
        }
        return separator + "\n" + text + "\n" + separator + "\n" + getBody() + separator + "\n";
    }
}
