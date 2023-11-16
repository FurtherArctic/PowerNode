package com.powernode.util;

import java.lang.reflect.Field;

/**
 * 开发一个方法,根据得到的数据自动生成一个insert语句.
 * insert语句中,insert into是固定的,
 * 表名,字段名,插入数据内容都需要开户提供.
 * <p>
 * 而实体类Entity代表一个表,类中的属性代表表中的字段,一个Entity对象代表一行数据.
 * <p>
 * 在Dao层,通过反射获取类名(表名),属性(字段名),对象(数据)
 */
public class ReflectUtil {
    public static String createInsert(Object entity) throws IllegalAccessException {
        StringBuilder sql = new StringBuilder("insert into ");
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("values(");
        //1.获取添加语句中的表名,对应Entity类的类名
        Class<?> entityClass = entity.getClass();
        String tableName = entityClass.getSimpleName().toUpperCase();

        //2. 获取添加语句中的字段名(实体类属性名称)
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            //获取字段名,对应Entity类的属性名
            String columnName = field.getName();
            //获取数据行,对应Entity对象的属性值
            Object value = field.get(entity);
            //如果该属性值为null或者空,则表示该字段不需要插入数据
            if (value != null && !"".equals(value)) {
                //columns和values只有一个"("时表示还没有添加元素,不需要使用","隔开字段名
                //columns长度大于1时,表示已经有了字段名,后续字段名需要和前一个使用","隔开
                if (columns.toString().length() > 1) {
                    columns.append(",");
                    values.append(",");
                }
                columns.append(columnName);
                //values值需要使用单引号包围,mysql可以自动把单引号包围的数字转为int型
                values.append("'");
                values.append(value);
                values.append("'");
            }
        }
        columns.append(") ");
        values.append(") ");
        sql.append(tableName);
        sql.append(columns);
        sql.append(values);

        return sql.toString();
    }

    public static String createUpdate(Object entity) throws Exception {
        StringBuilder sql = new StringBuilder("update ");
        StringBuilder where = new StringBuilder(" where ");
        StringBuilder columns = new StringBuilder();

        Class<?> entityClass = entity.getClass();

        String tableName = entityClass.getSimpleName().toUpperCase();
        sql.append(tableName).append(" SET ");
        Field[] columnNames = entityClass.getDeclaredFields();
        for (int i = 0; i < columnNames.length; i++) {
            Field field = columnNames[i];
            field.setAccessible(true);
            String columnName = field.getName();
            Object value = field.get(entity);
            if (value != null && !"".equals(value)) {
                if (i == 0) {
                    where.append(columnName).append("=").append(value);
                } else if (i != columnNames.length - 1) {
                    columns.append(columnName).append("='").append(value).append("',");
                } else if (i == columnNames.length - 1) {
                    columns.append(columnName).append("='").append(value).append("'");
                }
            }
        }
        return sql.append(columns).append(where).toString();
    }
}
